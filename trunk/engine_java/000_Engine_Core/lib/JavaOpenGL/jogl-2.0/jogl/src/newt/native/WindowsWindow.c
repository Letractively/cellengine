/*
 * Copyright (c) 2008 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN
 * MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR
 * ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR
 * DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE
 * DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY,
 * ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF
 * SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 */

#include <Windows.h>
#include <Windowsx.h>
#include <tchar.h>
#include <stdlib.h>
// NOTE: it looks like SHFullScreen and/or aygshell.dll is not available on the APX 2500 any more
// #ifdef UNDER_CE
// #include "aygshell.h"
// #endif

/* This typedef is apparently needed for Microsoft compilers before VC8,
   and on Windows CE */
#if (_MSC_VER < 1400) || defined(UNDER_CE)
    #ifdef _WIN64
        typedef long long intptr_t;
    #else
        typedef int intptr_t;
    #endif
#elif _MSC_VER <= 1500
    #ifdef _WIN64 // [
        typedef __int64           intptr_t;
    #else // _WIN64 ][
        typedef int               intptr_t;
    #endif // _WIN64 ]
#else
    #include <inttypes.h>
#endif

#if _MSC_VER <= 1500
    // FIXME: Determine for which MSVC versions ..
    #define strdup(s) _strdup(s)
#endif

#ifndef WM_MOUSEWHEEL
#define WM_MOUSEWHEEL                   0x020A
#endif //WM_MOUSEWHEEL

#ifndef WHEEL_DELTA
#define WHEEL_DELTA                     120
#endif //WHEEL_DELTA

#ifndef WHEEL_PAGESCROLL
#define WHEEL_PAGESCROLL                (UINT_MAX)
#endif //WHEEL_PAGESCROLL

#ifndef GET_WHEEL_DELTA_WPARAM  // defined for (_WIN32_WINNT >= 0x0500)
#define GET_WHEEL_DELTA_WPARAM(wParam)  ((short)HIWORD(wParam))
#endif

#ifndef MONITOR_DEFAULTTONULL
#define MONITOR_DEFAULTTONULL 0
#endif
#ifndef MONITOR_DEFAULTTOPRIMARY
#define MONITOR_DEFAULTTOPRIMARY 1
#endif
#ifndef MONITOR_DEFAULTTONEAREST
#define MONITOR_DEFAULTTONEAREST 2
#endif

#include "com_sun_javafx_newt_windows_WindowsWindow.h"

#include "EventListener.h"
#include "MouseEvent.h"
#include "InputEvent.h"
#include "KeyEvent.h"

// #define VERBOSE_ON 1

#ifdef VERBOSE_ON
    #define DBG_PRINT(...) fprintf(stderr, __VA_ARGS__); fflush(stderr) 
#else
    #define DBG_PRINT(...)
#endif

static jmethodID sizeChangedID = NULL;
static jmethodID windowSizingID = NULL;
static jmethodID insetsChangedID = NULL;
static jmethodID positionChangedID = NULL;
static jmethodID focusChangedID = NULL;
static jmethodID windowDestroyNotifyID = NULL;
static jmethodID windowDestroyedID = NULL;
static jmethodID sendMouseEventID = NULL;
static jmethodID sendKeyEventID = NULL;
static jmethodID sendPaintEventID = NULL;

static RECT* UpdateInsets(JNIEnv *env, HWND hwnd, jobject window);
static void CallInitScreens(JNIEnv *env);

static int g_nMonitorCounter = 0;
static int g_nMonitorLimit = 0;
static HMONITOR* g_hmpMonitors = NULL;

static HWND g_toolkitHwnd;

static int IDT_DISPLAY = 0x101;
static UINT_PTR g_displayTimerID = 0;

typedef struct {
    JNIEnv* jenv;
    jobject jinstance;
} WindowUserData;
    
typedef struct {
    UINT javaKey;
    UINT windowsKey;
} KeyMapEntry;

// Static table, arranged more or less spatially.
static KeyMapEntry keyMapTable[] = {
    // Modifier keys
    {J_VK_CAPS_LOCK,        VK_CAPITAL},
    {J_VK_SHIFT,            VK_SHIFT},
    {J_VK_CONTROL,          VK_CONTROL},
    {J_VK_ALT,              VK_MENU},
    {J_VK_NUM_LOCK,         VK_NUMLOCK},

    // Miscellaneous Windows keys
    {J_VK_WINDOWS,          VK_LWIN},
    {J_VK_WINDOWS,          VK_RWIN},
    {J_VK_CONTEXT_MENU,     VK_APPS},

    // Alphabet
    {J_VK_A,                'A'},
    {J_VK_B,                'B'},
    {J_VK_C,                'C'},
    {J_VK_D,                'D'},
    {J_VK_E,                'E'},
    {J_VK_F,                'F'},
    {J_VK_G,                'G'},
    {J_VK_H,                'H'},
    {J_VK_I,                'I'},
    {J_VK_J,                'J'},
    {J_VK_K,                'K'},
    {J_VK_L,                'L'},
    {J_VK_M,                'M'},
    {J_VK_N,                'N'},
    {J_VK_O,                'O'},
    {J_VK_P,                'P'},
    {J_VK_Q,                'Q'},
    {J_VK_R,                'R'},
    {J_VK_S,                'S'},
    {J_VK_T,                'T'},
    {J_VK_U,                'U'},
    {J_VK_V,                'V'},
    {J_VK_W,                'W'},
    {J_VK_X,                'X'},
    {J_VK_Y,                'Y'},
    {J_VK_Z,                'Z'},
    {J_VK_0,                '0'},
    {J_VK_1,                '1'},
    {J_VK_2,                '2'},
    {J_VK_3,                '3'},
    {J_VK_4,                '4'},
    {J_VK_5,                '5'},
    {J_VK_6,                '6'},
    {J_VK_7,                '7'},
    {J_VK_8,                '8'},
    {J_VK_9,                '9'},
    {J_VK_ENTER,            VK_RETURN},
    {J_VK_SPACE,            VK_SPACE},
    {J_VK_BACK_SPACE,       VK_BACK},
    {J_VK_TAB,              VK_TAB},
    {J_VK_ESCAPE,           VK_ESCAPE},
    {J_VK_INSERT,           VK_INSERT},
    {J_VK_DELETE,           VK_DELETE},
    {J_VK_HOME,             VK_HOME},
    {J_VK_END,              VK_END},
    {J_VK_PAGE_UP,          VK_PRIOR},
    {J_VK_PAGE_DOWN,        VK_NEXT},
    {J_VK_CLEAR,            VK_CLEAR}, // NumPad 5

    // NumPad with NumLock off & extended arrows block (triangular)
    {J_VK_LEFT,             VK_LEFT},
    {J_VK_RIGHT,            VK_RIGHT},
    {J_VK_UP,               VK_UP},
    {J_VK_DOWN,             VK_DOWN},

    // NumPad with NumLock on: numbers
    {J_VK_NUMPAD0,          VK_NUMPAD0},
    {J_VK_NUMPAD1,          VK_NUMPAD1},
    {J_VK_NUMPAD2,          VK_NUMPAD2},
    {J_VK_NUMPAD3,          VK_NUMPAD3},
    {J_VK_NUMPAD4,          VK_NUMPAD4},
    {J_VK_NUMPAD5,          VK_NUMPAD5},
    {J_VK_NUMPAD6,          VK_NUMPAD6},
    {J_VK_NUMPAD7,          VK_NUMPAD7},
    {J_VK_NUMPAD8,          VK_NUMPAD8},
    {J_VK_NUMPAD9,          VK_NUMPAD9},

    // NumPad with NumLock on
    {J_VK_MULTIPLY,         VK_MULTIPLY},
    {J_VK_ADD,              VK_ADD},
    {J_VK_SEPARATOR,        VK_SEPARATOR},
    {J_VK_SUBTRACT,         VK_SUBTRACT},
    {J_VK_DECIMAL,          VK_DECIMAL},
    {J_VK_DIVIDE,           VK_DIVIDE},

    // Functional keys
    {J_VK_F1,               VK_F1},
    {J_VK_F2,               VK_F2},
    {J_VK_F3,               VK_F3},
    {J_VK_F4,               VK_F4},
    {J_VK_F5,               VK_F5},
    {J_VK_F6,               VK_F6},
    {J_VK_F7,               VK_F7},
    {J_VK_F8,               VK_F8},
    {J_VK_F9,               VK_F9},
    {J_VK_F10,              VK_F10},
    {J_VK_F11,              VK_F11},
    {J_VK_F12,              VK_F12},
    {J_VK_F13,              VK_F13},
    {J_VK_F14,              VK_F14},
    {J_VK_F15,              VK_F15},
    {J_VK_F16,              VK_F16},
    {J_VK_F17,              VK_F17},
    {J_VK_F18,              VK_F18},
    {J_VK_F19,              VK_F19},
    {J_VK_F20,              VK_F20},
    {J_VK_F21,              VK_F21},
    {J_VK_F22,              VK_F22},
    {J_VK_F23,              VK_F23},
    {J_VK_F24,              VK_F24},

    {J_VK_PRINTSCREEN,      VK_SNAPSHOT},
    {J_VK_SCROLL_LOCK,      VK_SCROLL},
    {J_VK_PAUSE,            VK_PAUSE},
    {J_VK_CANCEL,           VK_CANCEL},
    {J_VK_HELP,             VK_HELP},

    // Japanese
/*
    {J_VK_CONVERT,          VK_CONVERT},
    {J_VK_NONCONVERT,       VK_NONCONVERT},
    {J_VK_INPUT_METHOD_ON_OFF, VK_KANJI},
    {J_VK_ALPHANUMERIC,     VK_DBE_ALPHANUMERIC},
    {J_VK_KATAKANA,         VK_DBE_KATAKANA},
    {J_VK_HIRAGANA,         VK_DBE_HIRAGANA},
    {J_VK_FULL_WIDTH,       VK_DBE_DBCSCHAR},
    {J_VK_HALF_WIDTH,       VK_DBE_SBCSCHAR},
    {J_VK_ROMAN_CHARACTERS, VK_DBE_ROMAN},
*/

    {J_VK_UNDEFINED,        0}
};

/*
Dynamic mapping table for OEM VK codes.  This table is refilled
by BuildDynamicKeyMapTable when keyboard layout is switched.
(see NT4 DDK src/input/inc/vkoem.h for OEM VK_ values).
*/
typedef struct {
    // OEM VK codes known in advance
    UINT windowsKey;
    // depends on input langauge (kbd layout)
    UINT javaKey;
} DynamicKeyMapEntry;

static DynamicKeyMapEntry dynamicKeyMapTable[] = {
    {0x00BA,  J_VK_UNDEFINED}, // VK_OEM_1
    {0x00BB,  J_VK_UNDEFINED}, // VK_OEM_PLUS
    {0x00BC,  J_VK_UNDEFINED}, // VK_OEM_COMMA
    {0x00BD,  J_VK_UNDEFINED}, // VK_OEM_MINUS
    {0x00BE,  J_VK_UNDEFINED}, // VK_OEM_PERIOD
    {0x00BF,  J_VK_UNDEFINED}, // VK_OEM_2
    {0x00C0,  J_VK_UNDEFINED}, // VK_OEM_3
    {0x00DB,  J_VK_UNDEFINED}, // VK_OEM_4
    {0x00DC,  J_VK_UNDEFINED}, // VK_OEM_5
    {0x00DD,  J_VK_UNDEFINED}, // VK_OEM_6
    {0x00DE,  J_VK_UNDEFINED}, // VK_OEM_7
    {0x00DF,  J_VK_UNDEFINED}, // VK_OEM_8
    {0x00E2,  J_VK_UNDEFINED}, // VK_OEM_102
    {0, 0}
};

// Auxiliary tables used to fill the above dynamic table.  We first
// find the character for the OEM VK code using ::MapVirtualKey and
// then go through these auxiliary tables to map it to Java VK code.

typedef struct {
    WCHAR c;
    UINT  javaKey;
} CharToVKEntry;

static const CharToVKEntry charToVKTable[] = {
    {L'!',   J_VK_EXCLAMATION_MARK},
    {L'"',   J_VK_QUOTEDBL},
    {L'#',   J_VK_NUMBER_SIGN},
    {L'$',   J_VK_DOLLAR},
    {L'&',   J_VK_AMPERSAND},
    {L'\'',  J_VK_QUOTE},
    {L'(',   J_VK_LEFT_PARENTHESIS},
    {L')',   J_VK_RIGHT_PARENTHESIS},
    {L'*',   J_VK_ASTERISK},
    {L'+',   J_VK_PLUS},
    {L',',   J_VK_COMMA},
    {L'-',   J_VK_MINUS},
    {L'.',   J_VK_PERIOD},
    {L'/',   J_VK_SLASH},
    {L':',   J_VK_COLON},
    {L';',   J_VK_SEMICOLON},
    {L'<',   J_VK_LESS},
    {L'=',   J_VK_EQUALS},
    {L'>',   J_VK_GREATER},
    {L'@',   J_VK_AT},
    {L'[',   J_VK_OPEN_BRACKET},
    {L'\\',  J_VK_BACK_SLASH},
    {L']',   J_VK_CLOSE_BRACKET},
    {L'^',   J_VK_CIRCUMFLEX},
    {L'_',   J_VK_UNDERSCORE},
    {L'`',   J_VK_BACK_QUOTE},
    {L'{',   J_VK_BRACELEFT},
    {L'}',   J_VK_BRACERIGHT},
    {0x00A1, J_VK_INVERTED_EXCLAMATION_MARK},
    {0x20A0, J_VK_EURO_SIGN}, // ????
    {0,0}
};

// For dead accents some layouts return ASCII punctuation, while some
// return spacing accent chars, so both should be listed.  NB: MS docs
// say that conversion routings return spacing accent character, not
// combining.
static const CharToVKEntry charToDeadVKTable[] = {
    {L'`',   J_VK_DEAD_GRAVE},
    {L'\'',  J_VK_DEAD_ACUTE},
    {0x00B4, J_VK_DEAD_ACUTE},
    {L'^',   J_VK_DEAD_CIRCUMFLEX},
    {L'~',   J_VK_DEAD_TILDE},
    {0x02DC, J_VK_DEAD_TILDE},
    {0x00AF, J_VK_DEAD_MACRON},
    {0x02D8, J_VK_DEAD_BREVE},
    {0x02D9, J_VK_DEAD_ABOVEDOT},
    {L'"',   J_VK_DEAD_DIAERESIS},
    {0x00A8, J_VK_DEAD_DIAERESIS},
    {0x02DA, J_VK_DEAD_ABOVERING},
    {0x02DD, J_VK_DEAD_DOUBLEACUTE},
    {0x02C7, J_VK_DEAD_CARON},            // aka hacek
    {L',',   J_VK_DEAD_CEDILLA},
    {0x00B8, J_VK_DEAD_CEDILLA},
    {0x02DB, J_VK_DEAD_OGONEK},
    {0x037A, J_VK_DEAD_IOTA},             // ASCII ???
    {0x309B, J_VK_DEAD_VOICED_SOUND},
    {0x309C, J_VK_DEAD_SEMIVOICED_SOUND},
    {0,0}
};

// ANSI CP identifiers are no longer than this
#define MAX_ACP_STR_LEN 7

static void BuildDynamicKeyMapTable()
{
    HKL hkl = GetKeyboardLayout(0);
    // Will need this to reset layout after dead keys.
    UINT spaceScanCode = MapVirtualKeyEx(VK_SPACE, 0, hkl);
    DynamicKeyMapEntry *dynamic;

    LANGID idLang = LOWORD(GetKeyboardLayout(0));
    UINT codePage;
    TCHAR strCodePage[MAX_ACP_STR_LEN];
    // use the LANGID to create a LCID
    LCID idLocale = MAKELCID(idLang, SORT_DEFAULT);
    // get the ANSI code page associated with this locale
    if (GetLocaleInfo(idLocale, LOCALE_IDEFAULTANSICODEPAGE,
	strCodePage, sizeof(strCodePage)/sizeof(TCHAR)) > 0 )
    {
        codePage = _ttoi(strCodePage);
    } else {
        codePage = GetACP();
    }

    // Entries in dynamic table that maps between Java VK and Windows
    // VK are built in three steps:
    //   1. Map windows VK to ANSI character (cannot map to unicode
    //      directly, since ::ToUnicode is not implemented on win9x)
    //   2. Convert ANSI char to Unicode char
    //   3. Map Unicode char to Java VK via two auxilary tables.

    for (dynamic = dynamicKeyMapTable; dynamic->windowsKey != 0; ++dynamic)
    {
        char cbuf[2] = { '\0', '\0'};
        WCHAR ucbuf[2] = { L'\0', L'\0' };
        int nchars;
        UINT scancode;
        const CharToVKEntry *charMap;
        int nconverted;
        WCHAR uc;
        BYTE kbdState[256];

        // Defaults to J_VK_UNDEFINED
        dynamic->javaKey = J_VK_UNDEFINED;

        GetKeyboardState(kbdState);

        kbdState[dynamic->windowsKey] |=  0x80; // Press the key.

        // Unpress modifiers, since they are most likely pressed as
        // part of the keyboard switching shortcut.
        kbdState[VK_CONTROL] &= ~0x80;
        kbdState[VK_SHIFT]   &= ~0x80;
        kbdState[VK_MENU]    &= ~0x80;

        scancode = MapVirtualKeyEx(dynamic->windowsKey, 0, hkl);
        nchars = ToAsciiEx(dynamic->windowsKey, scancode, kbdState,
                                 (WORD*)cbuf, 0, hkl);

        // Auxiliary table used to map Unicode character to Java VK.
        // Will assign a different table for dead keys (below).
        charMap = charToVKTable;

        if (nchars < 0) { // Dead key
            char junkbuf[2] = { '\0', '\0'};
            // Use a different table for dead chars since different layouts
            // return different characters for the same dead key.
            charMap = charToDeadVKTable;

            // We also need to reset layout so that next translation
            // is unaffected by the dead status.  We do this by
            // translating <SPACE> key.
            kbdState[dynamic->windowsKey] &= ~0x80;
            kbdState[VK_SPACE] |= 0x80;

            ToAsciiEx(VK_SPACE, spaceScanCode, kbdState,
                      (WORD*)junkbuf, 0, hkl);
        }

        nconverted = MultiByteToWideChar(codePage, 0,
                                         cbuf, 1, ucbuf, 2);

        uc = ucbuf[0];
        {
            const CharToVKEntry *map;
            for (map = charMap;  map->c != 0;  ++map) {
                if (uc == map->c) {
                    dynamic->javaKey = map->javaKey;
                    break;
                }
            }
        }

    } // for each VK_OEM_*
}

// Really need to factor this out in to a separate run-time file
static jchar* GetNullTerminatedStringChars(JNIEnv* env, jstring str)
{
    jchar* strChars = NULL;
    strChars = calloc((*env)->GetStringLength(env, str) + 1, sizeof(jchar));
    if (strChars != NULL) {
        (*env)->GetStringRegion(env, str, 0, (*env)->GetStringLength(env, str), strChars);
    }
    return strChars;
}

static void NwtSetWindowLongPtr(HWND hwnd, void * ptr) {
#if defined(UNDER_CE) || _MSC_VER <= 1200
    SetWindowLong(hwnd, GWL_USERDATA, (intptr_t) ptr);
#else
    SetWindowLongPtr(hwnd, GWLP_USERDATA, (intptr_t) ptr);
#endif
}

static void* NwtGetWindowLongPtr(HWND hwnd) {
#if defined(UNDER_CE) || _MSC_VER <= 1200
    return (void*)GetWindowLong(hwnd, GWL_USERDATA);
#else
    return (void*)GetWindowLongPtr(hwnd, GWLP_USERDATA);
#endif
}

static jint GetModifiers() {
    jint modifiers = 0;
    // have to do &0xFFFF to avoid runtime assert caused by compiling with
    // /RTCcsu
    if (HIBYTE((GetKeyState(VK_CONTROL) & 0xFFFF)) != 0) {
        modifiers |= EVENT_CTRL_MASK;
    }
    if (HIBYTE((GetKeyState(VK_SHIFT) & 0xFFFF)) != 0) {
        modifiers |= EVENT_SHIFT_MASK;
    }
    if (HIBYTE((GetKeyState(VK_MENU) & 0xFFFF)) != 0) {
        modifiers |= EVENT_ALT_MASK;
    }
    if (HIBYTE((GetKeyState(VK_LBUTTON) & 0xFFFF)) != 0) {
        modifiers |= EVENT_BUTTON1_MASK;
    }
    if (HIBYTE((GetKeyState(VK_MBUTTON) & 0xFFFF)) != 0) {
        modifiers |= EVENT_BUTTON2_MASK;
    }
    if (HIBYTE((GetKeyState(VK_RBUTTON) & 0xFFFF)) != 0) {
        modifiers |= EVENT_BUTTON3_MASK;
    }

    return modifiers;
}

static int WmChar(JNIEnv *env, jobject window, UINT character, UINT repCnt,
                  UINT flags, BOOL system)
{
    // The Alt modifier is reported in the 29th bit of the lParam,
    // i.e., it is the 13th bit of `flags' (which is HIWORD(lParam)).
    BOOL alt_is_down = (flags & (1<<13)) != 0;
    if (system && alt_is_down) {
        if (character == VK_SPACE) {
            return 1;
        }
    }

    if (character == VK_RETURN) {
        character = J_VK_ENTER;
    }
    (*env)->CallVoidMethod(env, window, sendKeyEventID,
                           (jint) EVENT_KEY_TYPED,
                           GetModifiers(),
                           (jint) -1,
                           (jchar) character);
    return 1;
}

UINT WindowsKeyToJavaKey(UINT windowsKey, UINT modifiers)
{
    int i, j;
    // for the general case, use a bi-directional table
    for (i = 0; keyMapTable[i].windowsKey != 0; i++) {
        if (keyMapTable[i].windowsKey == windowsKey) {
            return keyMapTable[i].javaKey;
        }
    }
    for (j = 0; dynamicKeyMapTable[j].windowsKey != 0; j++) {
        if (dynamicKeyMapTable[j].windowsKey == windowsKey) {
            if (dynamicKeyMapTable[j].javaKey != J_VK_UNDEFINED) {
                return dynamicKeyMapTable[j].javaKey;
            } else {
                break;
            }
        }
    }

    return J_VK_UNDEFINED;
}

static int WmKeyDown(JNIEnv *env, jobject window, UINT wkey, UINT repCnt,
                     UINT flags, BOOL system)
{
    UINT modifiers = 0, jkey = 0, character = -1;
    if (wkey == VK_PROCESSKEY) {
        return 1;
    }

    modifiers = GetModifiers();
    jkey = WindowsKeyToJavaKey(wkey, modifiers);

/*
    character = WindowsKeyToJavaChar(wkey, modifiers, SAVE);
*/

    (*env)->CallVoidMethod(env, window, sendKeyEventID,
                           (jint) EVENT_KEY_PRESSED,
                           modifiers,
                           (jint) jkey,
                           (jchar) character);

    /* windows does not create a WM_CHAR for the Del key
       for some reason, so we need to create the KEY_TYPED event on the
       WM_KEYDOWN.
     */
    if (jkey == J_VK_DELETE) {
        (*env)->CallVoidMethod(env, window, sendKeyEventID,
                               (jint) EVENT_KEY_TYPED,
                               GetModifiers(),
                               (jint) -1,
                               (jchar) '\177');
    }

    return 0;
}

static int WmKeyUp(JNIEnv *env, jobject window, UINT wkey, UINT repCnt,
                   UINT flags, BOOL system)
{
    UINT modifiers = 0, jkey = 0, character = -1;
    if (wkey == VK_PROCESSKEY) {
        return 1;
    }

    modifiers = GetModifiers();
    jkey = WindowsKeyToJavaKey(wkey, modifiers);
/*
    character = WindowsKeyToJavaChar(wkey, modifiers, SAVE);
*/

    (*env)->CallVoidMethod(env, window, sendKeyEventID,
                           (jint) EVENT_KEY_RELEASED,
                           modifiers,
                           (jint) jkey,
                           (jchar) character);

    return 0;
}

static RECT * UpdateInsets(JNIEnv *env, HWND hwnd, jobject window)
{
    // being naughty here
    static RECT m_insets = { 0, 0, 0, 0 };
    RECT outside;
    RECT inside;

    if (IsIconic(hwnd)) {
        m_insets.left = m_insets.top = m_insets.right = m_insets.bottom = -1;
        return FALSE;
    }

    m_insets.left = m_insets.top = m_insets.right = m_insets.bottom = 0;

    GetClientRect(hwnd, &inside);
    GetWindowRect(hwnd, &outside);

    if (outside.right - outside.left > 0 && outside.bottom - outside.top > 0) {
        MapWindowPoints(hwnd, 0, (LPPOINT)&inside, 2);
        m_insets.top = inside.top - outside.top;
        m_insets.bottom = outside.bottom - inside.bottom;
        m_insets.left = inside.left - outside.left;
        m_insets.right = outside.right - inside.right;
    } else {
        m_insets.top = -1;
    }
    if (m_insets.left < 0 || m_insets.top < 0 ||
        m_insets.right < 0 || m_insets.bottom < 0)
    {
        LONG style = GetWindowLong(hwnd, GWL_STYLE);
        // TODO: TDV: better undecorated checking needed

        BOOL bIsUndecorated = (style & (WS_CHILD|WS_POPUP|WS_SYSMENU)) != 0;
        if (!bIsUndecorated) {
            /* Get outer frame sizes. */
            if (style & WS_THICKFRAME) {
                m_insets.left = m_insets.right =
                    GetSystemMetrics(SM_CXSIZEFRAME);
                m_insets.top = m_insets.bottom =
                    GetSystemMetrics(SM_CYSIZEFRAME);
            } else {
                m_insets.left = m_insets.right =
                    GetSystemMetrics(SM_CXDLGFRAME);
                m_insets.top = m_insets.bottom =
                    GetSystemMetrics(SM_CYDLGFRAME);
            }

            /* Add in title. */
            m_insets.top += GetSystemMetrics(SM_CYCAPTION);
        } else {
            /* undo the -1 set above */
            m_insets.left = m_insets.top = m_insets.right = m_insets.bottom = 0;
        }
    }

    DBG_PRINT("*** WindowsWindow: UpdateInsets window %p, %d/%d %dx%d\n", hwnd, 
        m_insets.left, m_insets.top, m_insets.right-m_insets.left, m_insets.top-m_insets.bottom);

    (*env)->CallVoidMethod(env, window, insetsChangedID,
                           m_insets.left, m_insets.top,
                           m_insets.right, m_insets.bottom);
    return &m_insets;
}

static void WmSize(JNIEnv *env, HWND wnd, jobject window, UINT type)
{
    RECT rc;
    int w, h;

    // make sure insets are up to date
    (void)UpdateInsets(env, wnd, window);

    if (type == SIZE_MINIMIZED) {
        // TODO: deal with minimized window sizing
        return;
    }

    GetClientRect(wnd, &rc);
    
    // we report back the dimensions of the client area
    w = rc.right  - rc.left;
    h = rc.bottom - rc.top;

    (*env)->CallVoidMethod(env, window, sizeChangedID, w, h);
}

static VOID CALLBACK MyTimerProc(
    HWND hwnd,        // handle to window for timer messages
    UINT message,     // WM_TIMER message
    UINT idTimer,     // timer identifier
    DWORD dwTime)     // current system time
{
    WindowUserData * wud = NwtGetWindowLongPtr(hwnd);

    if (NULL == wud) {
        return;
    }

    (*wud->jenv)->CallVoidMethod(wud->jenv, wud->jinstance, windowSizingID);
}

static LRESULT CALLBACK wndProc(HWND wnd, UINT message,
                                WPARAM wParam, LPARAM lParam)
{
    int useDefWindowProc = 0;
    JNIEnv *env = NULL;
    jobject window = NULL;
    BOOL isKeyDown = FALSE;
    WindowUserData * wud;

#if defined(UNDER_CE) || _MSC_VER <= 1200
    wud = (WindowUserData *) GetWindowLong(wnd, GWL_USERDATA);
#else
    wud = (WindowUserData *) GetWindowLongPtr(wnd, GWLP_USERDATA);
#endif
    if(NULL==wud) {
        return DefWindowProc(wnd, message, wParam, lParam);
    }
    env = wud->jenv;
    window = wud->jinstance;

    if (wnd == g_toolkitHwnd || NULL==window || NULL==env) {
        /* handle "global" app-level events here */
        if (g_toolkitHwnd == wnd) {
            switch (message) {
                case WM_SETTINGCHANGE:
                    if ((wParam & SPI_SETWORKAREA) != 0) {
                        CallInitScreens(env);
                        return 0;
                    }
                    break;
            }
        }

        return DefWindowProc(wnd, message, wParam, lParam);
    }

    // DBG_PRINT("*** WindowsWindow: window %p -> %p, 0x%X %d/%d\n", wnd, window, message, (int)LOWORD(lParam), (int)HIWORD(lParam));

    switch (message) {

    //
    // The signal pipeline for destruction is:
    //    Java::DestroyWindow(wnd) _or_ window-close-button -> 
    //     WM_CLOSE -> Java::windowDestroyNotify -> W_DESTROY -> Java::windowDestroyed ->
    //       Java::CleanupWindowResources()
    case WM_CLOSE:
        (*env)->CallVoidMethod(env, window, windowDestroyNotifyID);
        break;

    case WM_DESTROY:
        {
#if defined(UNDER_CE) || _MSC_VER <= 1200
            SetWindowLong(wnd, GWL_USERDATA, (intptr_t) NULL);
#else
            SetWindowLongPtr(wnd, GWLP_USERDATA, (intptr_t) NULL);
#endif
            free(wud); wud=NULL;
            (*env)->CallVoidMethod(env, window, windowDestroyedID);
            (*env)->DeleteGlobalRef(env, window);
        }
        break;

    case WM_SYSCHAR:
        useDefWindowProc = WmChar(env, window, wParam,
                                  LOWORD(lParam), HIWORD(lParam), FALSE);
        break;

    case WM_CHAR:
        useDefWindowProc = WmChar(env, window, wParam,
                                  LOWORD(lParam), HIWORD(lParam), TRUE);
        break;
        
    case WM_KEYDOWN:
        useDefWindowProc = WmKeyDown(env, window, wParam,
                                     LOWORD(lParam), HIWORD(lParam), FALSE);
        break;

    case WM_KEYUP:
        useDefWindowProc = WmKeyUp(env, window, wParam,
                                   LOWORD(lParam), HIWORD(lParam), FALSE);
        break;

    case WM_SIZE:
        WmSize(env, wnd, window, (UINT)wParam);
        break;

    case WM_ENTERMENULOOP:
    case WM_INITMENUPOPUP:
    case WM_ENTERSIZEMOVE:
 	g_displayTimerID = SetTimer(wnd, IDT_DISPLAY, 16, MyTimerProc);
 	useDefWindowProc = 1;
 	break;

    case WM_EXITMENULOOP:
    case WM_UNINITMENUPOPUP:
    case WM_EXITSIZEMOVE:
 	if (g_displayTimerID) {
 	    KillTimer(wnd, g_displayTimerID);
 	}
 	g_displayTimerID = 0;
 	useDefWindowProc = 1;
 	break;

    case WM_SETTINGCHANGE:
        if (wParam == SPI_SETNONCLIENTMETRICS) {
            // make sure insets are updated, we don't need to resize the window 
            // because the size of the client area doesn't change
            (void)UpdateInsets(env, wnd, window);
        } else {
            useDefWindowProc = 1;
        }
        break;


    case WM_LBUTTONDOWN:
        (*env)->CallVoidMethod(env, window, sendMouseEventID,
                               (jint) EVENT_MOUSE_PRESSED,
                               GetModifiers(),
                               (jint) LOWORD(lParam), (jint) HIWORD(lParam),
                               (jint) 1, (jint) 0);
        useDefWindowProc = 1;
        break;

    case WM_LBUTTONUP:
        (*env)->CallVoidMethod(env, window, sendMouseEventID,
                               (jint) EVENT_MOUSE_RELEASED,
                               GetModifiers(),
                               (jint) LOWORD(lParam), (jint) HIWORD(lParam),
                               (jint) 1, (jint) 0);
        useDefWindowProc = 1;
        break;

    case WM_MBUTTONDOWN:
        (*env)->CallVoidMethod(env, window, sendMouseEventID,
                               (jint) EVENT_MOUSE_PRESSED,
                               GetModifiers(),
                               (jint) LOWORD(lParam), (jint) HIWORD(lParam),
                               (jint) 2, (jint) 0);
        useDefWindowProc = 1;
        break;

    case WM_MBUTTONUP:
        (*env)->CallVoidMethod(env, window, sendMouseEventID,
                               (jint) EVENT_MOUSE_RELEASED,
                               GetModifiers(),
                               (jint) LOWORD(lParam), (jint) HIWORD(lParam),
                               (jint) 2, (jint) 0);
        useDefWindowProc = 1;
        break;

    case WM_RBUTTONDOWN:
        (*env)->CallVoidMethod(env, window, sendMouseEventID,
                               (jint) EVENT_MOUSE_PRESSED,
                               GetModifiers(),
                               (jint) LOWORD(lParam), (jint) HIWORD(lParam),
                               (jint) 3, (jint) 0);
        useDefWindowProc = 1;
        break;

    case WM_RBUTTONUP:
        (*env)->CallVoidMethod(env, window, sendMouseEventID,
                               (jint) EVENT_MOUSE_RELEASED,
                               GetModifiers(),
                               (jint) LOWORD(lParam), (jint) HIWORD(lParam),
                               (jint) 3,  (jint) 0);
        useDefWindowProc = 1;
        break;

    case WM_MOUSEMOVE:
        (*env)->CallVoidMethod(env, window, sendMouseEventID,
                               (jint) EVENT_MOUSE_MOVED,
                               GetModifiers(),
                               (jint) LOWORD(lParam), (jint) HIWORD(lParam),
                               (jint) 0,  (jint) 0);
        useDefWindowProc = 1;
        break;

    case WM_MOUSEWHEEL: {
        // need to convert the coordinates to component-relative
        int x = GET_X_LPARAM(lParam);
        int y = GET_Y_LPARAM(lParam);
        POINT eventPt;
        eventPt.x = x;
        eventPt.y = y;
        ScreenToClient(wnd, &eventPt);
        (*env)->CallVoidMethod(env, window, sendMouseEventID,
                               (jint) EVENT_MOUSE_WHEEL_MOVED,
                               GetModifiers(),
                               (jint) eventPt.x, (jint) eventPt.y,
                               (jint) 0,  (jint) (GET_WHEEL_DELTA_WPARAM(wParam)/120.0f));
        useDefWindowProc = 1;
        break;
    }

    case WM_SETFOCUS:
        (*env)->CallVoidMethod(env, window, focusChangedID,
                               (jlong)wParam, JNI_TRUE);
        useDefWindowProc = 1;
        break;

    case WM_KILLFOCUS:
        (*env)->CallVoidMethod(env, window, focusChangedID,
                               (jlong)wParam, JNI_FALSE);
        useDefWindowProc = 1;
        break;

    case WM_MOVE:
        DBG_PRINT("*** WindowsWindow: WM_MOVE window %p, %d/%d\n", wnd, (int)LOWORD(lParam), (int)HIWORD(lParam));
        (*env)->CallVoidMethod(env, window, positionChangedID,
                               (jint)LOWORD(lParam), (jint)HIWORD(lParam));
        useDefWindowProc = 1;
        break;

    case WM_PAINT: {
        RECT r;
        if (GetUpdateRect(wnd, &r, FALSE)) {
            if ((r.right-r.left) > 0 && (r.bottom-r.top) > 0) {
                (*env)->CallVoidMethod(env, window, sendPaintEventID,
                                       0, r.left, r.top, r.right-r.left, r.bottom-r.top);
            }
            ValidateRect(wnd, &r);
            useDefWindowProc = 0;
        } else {
            useDefWindowProc = 1;
        }
        break;
    }
    case WM_ERASEBKGND:
        // ignore erase background
        useDefWindowProc = 0;
        break;


    // FIXME: generate EVENT_MOUSE_ENTERED, EVENT_MOUSE_EXITED
    default:
        useDefWindowProc = 1;
    }

    if (useDefWindowProc)
        return DefWindowProc(wnd, message, wParam, lParam);
    return 0;
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsDisplay
 * Method:    DispatchMessages
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsDisplay_DispatchMessages
  (JNIEnv *env, jclass clazz)
{
    int i = 0;
    MSG msg;
    BOOL gotOne;

    // Periodically take a break
    do {
        gotOne = PeekMessage(&msg, (HWND) NULL, 0, 0, PM_REMOVE);
        if (gotOne) {
            ++i;
            TranslateMessage(&msg);
            DispatchMessage(&msg);
        }
    } while (gotOne && i < 100);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsDisplay
 * Method:    LoadLibraryW
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_javafx_newt_windows_WindowsDisplay_LoadLibraryW
  (JNIEnv *env, jclass clazz, jstring dllName)
{
    jchar* _dllName = GetNullTerminatedStringChars(env, dllName);
    HMODULE lib = LoadLibraryW(_dllName);
    free(_dllName);
    return (jlong) (intptr_t) lib;
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsDisplay
 * Method:    RegisterWindowClass
 * Signature: (Ljava/lang/String;J)I
 */
JNIEXPORT jint JNICALL Java_com_sun_javafx_newt_windows_WindowsDisplay_RegisterWindowClass
  (JNIEnv *env, jclass clazz, jstring wndClassName, jlong hInstance)
{
    ATOM res;
    WNDCLASS wc;
#ifndef UNICODE
    const char* _wndClassName = NULL;
#endif

    /* register class */
    wc.style = CS_HREDRAW | CS_VREDRAW;
    wc.lpfnWndProc = (WNDPROC)wndProc;
    wc.cbClsExtra = 0;
    wc.cbWndExtra = 0;
    /* This cast is legal because the HMODULE for a DLL is the same as
       its HINSTANCE -- see MSDN docs for DllMain */
    wc.hInstance = (HINSTANCE) (intptr_t) hInstance;
    wc.hIcon = NULL;
    wc.hCursor = LoadCursor(NULL, MAKEINTRESOURCE(IDC_ARROW));
    wc.hbrBackground = GetStockObject(BLACK_BRUSH);
    wc.lpszMenuName = NULL;
#ifdef UNICODE
    wc.lpszClassName = GetNullTerminatedStringChars(env, wndClassName);
#else
    _wndClassName = (*env)->GetStringUTFChars(env, wndClassName, NULL);
    wc.lpszClassName = strdup(_wndClassName);
    (*env)->ReleaseStringUTFChars(env, wndClassName, _wndClassName);
#endif
    res = RegisterClass(&wc);

    /* create a window which will respond to "global" events like display
       change, etc */
    g_toolkitHwnd = CreateWindow(wc.lpszClassName,
                                 (LPCTSTR)"NewToolkitWindow",
                                 WS_DISABLED,
                                 -1, -1,
                                 0, 0,
                                 NULL, NULL,
                                 wc.hInstance,
                                 NULL);

    if (g_toolkitHwnd != NULL) {
        WindowUserData * wud = (WindowUserData *) malloc(sizeof(WindowUserData));

        wud->jinstance = NULL;
        wud->jenv = env;

        NwtSetWindowLongPtr(g_toolkitHwnd, wud);
    }


    free((void *)wc.lpszClassName);

    return (jint)res;
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsDisplay
 * Method:    CleanupWindowResources
 * Signature: (java/lang/String;J)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsDisplay_UnregisterWindowClass
  (JNIEnv *env, jclass clazz, jint wndClassAtom, jlong hInstance)
{
    UnregisterClass(MAKEINTATOM(wndClassAtom), (HINSTANCE) (intptr_t) hInstance);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsScreen
 * Method:    getWidthImpl
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_sun_javafx_newt_windows_WindowsScreen_getWidthImpl
  (JNIEnv *env, jobject obj, jint scrn_idx)
{
    return (jint)GetSystemMetrics(SM_CXSCREEN);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsScreen
 * Method:    getWidthImpl
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_sun_javafx_newt_windows_WindowsScreen_getHeightImpl
  (JNIEnv *env, jobject obj, jint scrn_idx)
{
    return (jint)GetSystemMetrics(SM_CYSCREEN);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    initIDs
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_initIDs
  (JNIEnv *env, jclass clazz)
{
    sizeChangedID = (*env)->GetMethodID(env, clazz, "sizeChanged", "(II)V");
    windowSizingID = (*env)->GetMethodID(env, clazz, "windowSizing", "()V");
    insetsChangedID = (*env)->GetMethodID(env, clazz, "insetsChanged", "(IIII)V");
    positionChangedID = (*env)->GetMethodID(env, clazz, "positionChanged", "(II)V");
    focusChangedID = (*env)->GetMethodID(env, clazz, "focusChanged", "(JZ)V");
    windowDestroyNotifyID    = (*env)->GetMethodID(env, clazz, "windowDestroyNotify", "()V");
    windowDestroyedID = (*env)->GetMethodID(env, clazz, "windowDestroyed", "()V");
    sendMouseEventID = (*env)->GetMethodID(env, clazz, "sendMouseEvent", "(IIIIII)V");
    sendKeyEventID = (*env)->GetMethodID(env, clazz, "sendKeyEvent", "(IIIC)V");
    sendPaintEventID = (*env)->GetMethodID(env, clazz, "sendPaintEvent", "(IIIII)V");
    if (sizeChangedID == NULL ||
        windowSizingID == NULL ||
        insetsChangedID == NULL ||
        positionChangedID == NULL ||
        focusChangedID == NULL ||
        windowDestroyNotifyID == NULL ||
        windowDestroyedID == NULL ||
        sendMouseEventID == NULL ||
        sendPaintEventID == NULL ||
        sendKeyEventID == NULL)
    {
        return JNI_FALSE;
    }
    BuildDynamicKeyMapTable();
    return JNI_TRUE;
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    CreateWindow
 * Signature: (JILjava/lang/String;JJZIIII)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_CreateWindow
  (JNIEnv *env, jobject obj, jlong parent, jint wndClassAtom, jstring jWndName, jlong hInstance, jlong visualID,
        jboolean bIsUndecorated,
        jint jx, jint jy, jint defaultWidth, jint defaultHeight)
{
    HWND parentWindow = (HWND) (intptr_t) parent;
    const TCHAR* wndName = NULL;
    DWORD windowStyle = WS_CLIPSIBLINGS | WS_CLIPCHILDREN | WS_VISIBLE;
    int x=(int)jx, y=(int)jy;
    int width=(int)defaultWidth, height=(int)defaultHeight;
    HWND window = NULL;

#ifdef UNICODE
    wndName = GetNullTerminatedStringChars(env, jWndName);
#else
    wndName = (*env)->GetStringUTFChars(env, jWndName, NULL);
#endif

    if(NULL!=parentWindow) {
        windowStyle |= WS_CHILD ;
    } else if (bIsUndecorated) {
        windowStyle |= WS_POPUP | WS_SYSMENU | WS_MAXIMIZEBOX | WS_MINIMIZEBOX;
    } else {
        windowStyle |= WS_OVERLAPPEDWINDOW;
        x = CW_USEDEFAULT;
        y = 0;
    }

    (void) visualID; // FIXME: use the visualID ..

    window = CreateWindow(MAKEINTATOM(wndClassAtom), wndName, windowStyle,
                          x, y, width, height,
                          parentWindow, NULL,
                          (HINSTANCE) (intptr_t) hInstance,
                          NULL);

    DBG_PRINT("*** WindowsWindow: CreateWindow parent %p, window %p, %d/%d %dx%d\n", parentWindow, window, x, y, width, height);

    if (NULL != window) {
        WindowUserData * wud = (WindowUserData *) malloc(sizeof(WindowUserData));
        wud->jinstance = (*env)->NewGlobalRef(env, obj);
        wud->jenv = env;
#if defined(UNDER_CE) || _MSC_VER <= 1200
        SetWindowLong(window, GWL_USERDATA, (intptr_t) wud);
#else
        SetWindowLongPtr(window, GWLP_USERDATA, (intptr_t) wud);
#endif

        UpdateInsets(env, window, obj);

        // ShowWindow(window, SW_SHOWNORMAL);
    }

#ifdef UNICODE
    free((void*) wndName);
#else
    (*env)->ReleaseStringUTFChars(env, jWndName, wndName);
#endif


    return (jlong) (intptr_t) window;
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    DestroyWindow
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_DestroyWindow
  (JNIEnv *env, jobject obj, jlong window)
{
    DestroyWindow((HWND) (intptr_t) window);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    GetDC
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_GetDC
  (JNIEnv *env, jobject obj, jlong window)
{
    return (jlong) (intptr_t) GetDC((HWND) (intptr_t) window);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    ReleaseDC
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_ReleaseDC
  (JNIEnv *env, jobject obj, jlong window, jlong dc)
{
    ReleaseDC((HWND) (intptr_t) window, (HDC) (intptr_t) dc);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    MonitorFromWindow
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_MonitorFromWindow
  (JNIEnv *env, jobject obj, jlong window)
{
    #if (_WIN32_WINNT >= 0x0500 || _WIN32_WINDOWS >= 0x0410 || WINVER >= 0x0500) && !defined(_WIN32_WCE)
        return (jlong) (intptr_t) MonitorFromWindow((HWND) (intptr_t) window, MONITOR_DEFAULTTOPRIMARY);
    #else
        return 0;
    #endif
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    setVisible0
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_setVisible0
  (JNIEnv *_env, jclass clazz, jlong window, jboolean visible)
{
    HWND hWnd = (HWND) (intptr_t) window;
    DBG_PRINT("*** WindowsWindow: setVisible window %p, visible: %d\n", hWnd, (int)visible);
    if (visible) {
        ShowWindow(hWnd, SW_SHOW);
    } else {
        ShowWindow(hWnd, SW_HIDE);
    }
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    setSize0
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_setSize0
  (JNIEnv *env, jobject obj, jlong parent, jlong window, jint x, jint y, jint width, jint height)
{
    printf("in setSize0...\n"); fflush(stdout);
    RECT r;
    LONG style;
    BOOL bIsUndecorated;
    HWND hwndP = (HWND) (intptr_t) parent;
    HWND hwnd = (HWND) (intptr_t) window;
    RECT *pInsets = UpdateInsets(env, hwnd, obj);
    
    int nWidth=width, nHeight=height;

    GetWindowRect(hwnd, &r);
    // ensure that the client area is at least 1x1
    if (width <= 0) {
        width = 1;
    }
    if (height <= 0) {
        height = 1;
    }

    // ensure that the window is not too small
    nWidth = width + pInsets->left + pInsets->right;
    nHeight = height + pInsets->top + pInsets->bottom;
    if(NULL==hwndP) { // top level window
        int minWidth = GetSystemMetrics(SM_CXMIN);
        int minHeight = GetSystemMetrics(SM_CYMIN);
        // since width, height are the size of the client area, we need to add
        // insets
        nWidth = width + pInsets->left + pInsets->right;
        nHeight = height + pInsets->top + pInsets->bottom;

        if (nWidth < minWidth) {
            nWidth = minWidth;
        }
        if (nHeight < minHeight) {
            nHeight = minHeight;
        }
    }
    printf("in x of setSize0...\n"); fflush(stdout);
    MoveWindow(hwnd, r.left, r.top, nWidth, nHeight, TRUE);
    // we report back the size of client area
    GetClientRect(hwnd, &r);
    (*env)->CallVoidMethod(env, obj, sizeChangedID, r.right, r.bottom);
    printf("out of setSize0...\n"); fflush(stdout);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    setPosition
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_setPosition
  (JNIEnv *env, jobject obj, jlong parent, jlong window, jint x, jint y)
{
    UINT flags = SWP_NOACTIVATE | SWP_NOSIZE;
    HWND hwndP = (HWND) (intptr_t) parent;
    HWND hwnd = (HWND) (intptr_t) window;

    if(NULL==hwndP) {
        flags |= SWP_NOZORDER;
    }

    DBG_PRINT("*** WindowsWindow: setPosition parent %p, window %p, %d/%d\n", hwndP, hwnd, x, y);

    SetWindowPos(hwnd, hwndP, x, y, 0, 0, flags);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    setFullscreen
 * Signature: (JIIIIZZ)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_setFullscreen0
  (JNIEnv *env, jobject obj, jlong parent, jlong window, jint x, jint y, jint width, jint height, jboolean bIsUndecorated, jboolean on)
{
    UINT flags;
    HWND hwndP = (HWND) (intptr_t) parent;
    HWND hwnd = (HWND) (intptr_t) window;
    HWND hWndInsertAfter;
    DWORD windowStyle = WS_CLIPSIBLINGS | WS_CLIPCHILDREN | WS_VISIBLE;

    if(NULL!=hwndP) {
        windowStyle |= WS_CHILD ;
    } else if (bIsUndecorated || on) {
        windowStyle |= WS_POPUP | WS_SYSMENU | WS_MAXIMIZEBOX | WS_MINIMIZEBOX;
    } else {
        windowStyle |= WS_OVERLAPPEDWINDOW;
    }
    SetWindowLong(hwnd, GWL_STYLE, windowStyle);

    if(on==JNI_TRUE) {
        flags = SWP_SHOWWINDOW;
        hWndInsertAfter = HWND_TOPMOST;
    } else {
        flags = SWP_NOACTIVATE | SWP_NOZORDER;
        hWndInsertAfter = 0;
    }

    SetWindowPos(hwnd, hWndInsertAfter, x, y, width, height, flags);

    (*env)->CallVoidMethod(env, obj, sizeChangedID, (jint) width, (jint) height);
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    setTitle
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_setTitle
  (JNIEnv *env, jclass clazz, jlong window, jstring title)
{
    HWND hwnd = (HWND) (intptr_t) window;
    if (title != NULL) {
        jchar *titleString = GetNullTerminatedStringChars(env, title);
        if (titleString != NULL) {
            SetWindowTextW(hwnd, titleString);
            free(titleString);
        }
    }
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsWindow
 * Method:    requestFocus
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_requestFocus
  (JNIEnv *env, jclass clazz, jlong window)
{
    HWND hwnd = (HWND) (intptr_t) window;

    if (IsWindow(hwnd)) {
        SetFocus(hwnd);
    }
}

JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsWindow_setResizable
  (JNIEnv *env, jclass clazz, jlong window, jboolean isUndecorated, jboolean isResizable)
{
    HWND hwnd = (HWND) (intptr_t)window;

    // TODO: also will need to check if this is an embedded window
    if (IsWindow(hwnd)) {
        LONG resizeStyle = WS_MAXIMIZEBOX;
        LONG style = GetWindowLong(hwnd, GWL_STYLE);
        if (isUndecorated == FALSE) {
            resizeStyle |= WS_THICKFRAME;
        }
    
        if (isResizable) {
            style |= resizeStyle;
        } else {
            style &= ~resizeStyle;
        }
        SetWindowLong(hwnd, GWL_STYLE, style);
        SetWindowPos(hwnd, (HWND) NULL, 0, 0, 0, 0, 
                     SWP_ASYNCWINDOWPOS |
                     SWP_FRAMECHANGED   | /* causes WM_NCCALCSIZE to be called */
                     SWP_NOMOVE | SWP_NOSIZE | SWP_NOZORDER |
                     SWP_NOACTIVATE | SWP_NOCOPYBITS |
                     SWP_NOREPOSITION | SWP_NOSENDCHANGING);
    }
}
    
// Callback for CountMonitors below
BOOL WINAPI clb_fCountMonitors(HMONITOR hMon, HDC hDC, LPRECT rRect, LPARAM lP)
{
    g_nMonitorCounter ++;
    return TRUE;
}

int WINAPI CountMonitors(void)
{
    g_nMonitorCounter = 0;
    EnumDisplayMonitors(NULL, NULL, clb_fCountMonitors, 0L);
    return g_nMonitorCounter;

}

// Callback for CollectMonitors below
BOOL WINAPI clb_fCollectMonitors(HMONITOR hMon, HDC hDC, LPRECT rRect, LPARAM lP)
{

    if ((g_nMonitorCounter < g_nMonitorLimit) && (NULL != g_hmpMonitors)) {
        g_hmpMonitors[g_nMonitorCounter] = hMon;
        g_nMonitorCounter ++;
    }

    return TRUE;
}

int WINAPI CollectMonitors(HMONITOR* hmpMonitors, int nNum)
{
    int retCode = 0;

    if (NULL != hmpMonitors) {

        g_nMonitorCounter   = 0;
        g_nMonitorLimit     = nNum;
        g_hmpMonitors       = hmpMonitors;

        EnumDisplayMonitors(NULL, NULL, clb_fCollectMonitors, 0L);

        retCode             = g_nMonitorCounter;

        g_nMonitorCounter   = 0;
        g_nMonitorLimit     = 0;
        g_hmpMonitors       = NULL;

    }
    return retCode;
}

static void CallInitScreens(JNIEnv *env) {
    if (g_toolkitHwnd != NULL) {
        jclass clazz = 
            (*env)->FindClass(env,
                              "com/sun/javafx/newt/windows/WindowsScreensInfo");
        if (clazz != NULL) {
            jmethodID getInstanceMID =
                (*env)->GetStaticMethodID(env, clazz, "getInstance", 
                                          "()Lcom/sun/javafx/newt/ScreensInfo;");
            jmethodID initDataMID =
                (*env)->GetMethodID(env, clazz, "initScreens", "()V");
            if (initDataMID != NULL && getInstanceMID != NULL) {
                jobject wsi = (*env)->CallStaticObjectMethod(env, clazz, 
                                                             getInstanceMID);
                if (wsi != NULL) {
                    (*env)->CallVoidMethod(env, wsi, initDataMID);
                }
            }
        }
    }
}

static void InitScreensInfo(JNIEnv *env, jobject screensDataObj) {
    int numScreens, i, logX = 96, logY = 96;
    HMONITOR *monHds;
    MONITORINFOEX miInfo;
    jmethodID addScreenMID;
    jclass clazz;

    numScreens = CountMonitors();
    clazz = (*env)->FindClass(env, "com/sun/javafx/newt/windows/WindowsScreensInfo");
    if (numScreens <= 0 || clazz == NULL) {
        return;
    }

    monHds = (HMONITOR *)malloc(numScreens * sizeof(HMONITOR));
    if (monHds == NULL) {
        return;
    }

    addScreenMID = (*env)->GetMethodID(env, clazz, "addScreen", "(IJZIIIIIIIIFF)V");
    if (addScreenMID == NULL || numScreens != CollectMonitors(monHds, numScreens)) {
        free(monHds);
        return;
    }

    {
        HWND hWnd = GetDesktopWindow();
        HDC hDC = GetDC(hWnd);
        if (hDC != NULL) {
            logX = GetDeviceCaps(hDC, LOGPIXELSX);
            logY = GetDeviceCaps(hDC, LOGPIXELSX);
            ReleaseDC(hWnd, hDC);
        }
    }

    for (i = 0; i < numScreens; ++i) {
        memset((void*)(&miInfo), 0, sizeof(MONITORINFO));
        miInfo.cbSize = sizeof(MONITORINFO);

        if (TRUE == GetMonitorInfo(monHds[i], (LPMONITORINFO)&miInfo)) {
            int x = miInfo.rcMonitor.left;
            int y = miInfo.rcMonitor.top;
            int w = miInfo.rcMonitor.right - x;
            int h = miInfo.rcMonitor.bottom - y;
            int wx = miInfo.rcWork.left;
            int wy = miInfo.rcWork.top;
            int ww = miInfo.rcWork.right - wx;
            int wh = miInfo.rcWork.bottom - wy;

            (*env)->CallVoidMethod(env, screensDataObj, addScreenMID,
                                   i, (jlong)(intptr_t)monHds[i],
                                   (miInfo.dwFlags & MONITORINFOF_PRIMARY) != 0,
                                   x, y, w, h,
                                   wx, wy, ww, wh, (jfloat)logX, (jfloat)logY);
        }
    }

    free(monHds);    
}

/*
 * Class:     com_sun_javafx_newt_windows_WindowsScreensInfo
 * Method:    nInitData
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_windows_WindowsScreensInfo_nInitData
  (JNIEnv *env, jobject screensDataObj) 
{
    InitScreensInfo(env, screensDataObj);
}
