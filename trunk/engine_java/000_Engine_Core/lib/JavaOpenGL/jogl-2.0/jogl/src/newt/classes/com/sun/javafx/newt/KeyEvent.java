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

package com.sun.javafx.newt;

public class KeyEvent extends InputEvent
{
 KeyEvent(boolean sysEvent, int eventType, Window source, long when, int modifiers, int keyCode, char keyChar) {
     super(sysEvent, eventType, source, when, modifiers); 
     this.keyCode=keyCode;
     this.keyChar=keyChar;
 }
 public KeyEvent(int eventType, Window source, long when, int modifiers, int keyCode, char keyChar) {
     this(false, eventType, source, when, modifiers, keyCode, keyChar);
 }

 public char getKeyChar() {
    return keyChar;
 }
 public int getKeyCode() {
    return keyCode;
 }

 public String toString() {
    return "KeyEvent["+getEventTypeString(getEventType())+
                     ", code "+keyCode+"("+toHexString(keyCode)+"), char <"+keyChar+"> ("+toHexString((int)keyChar)+"), isActionKey "+isActionKey()+", "+super.toString()+"]";
 }

 public static String getEventTypeString(int type) {
    switch(type) {
        case EVENT_KEY_PRESSED: return "EVENT_KEY_PRESSED";
        case EVENT_KEY_RELEASED: return "EVENT_KEY_RELEASED";
        case EVENT_KEY_TYPED: return "EVENT_KEY_TYPED";
        default: return "unknown (" + type + ")";
    }
 }

    public static String getKeyText(int keyCode) {
        if (keyCode >= VK_0 && keyCode <= VK_9 ||
            keyCode >= VK_A && keyCode <= VK_Z) {
            return String.valueOf((char) keyCode);
        }

        switch (keyCode) {
            case VK_ENTER:
                return "Enter";
            case VK_BACK_SPACE:
                return "Backspace";
            case VK_TAB:
                return "Tab";
            case VK_CANCEL:
                return "Cancel";
            case VK_CLEAR:
                return "Clear";
            case VK_COMPOSE:
                return "Compose";
            case VK_PAUSE:
                return "Pause";
            case VK_CAPS_LOCK:
                return "Caps Lock";
            case VK_ESCAPE:
                return "Escape";
            case VK_SPACE:
                return "Space";
            case VK_PAGE_UP:
                return "Page Up";
            case VK_PAGE_DOWN:
                return "Page Down";
            case VK_END:
                return "End";
            case VK_HOME:
                return "Home";
            case VK_LEFT:
                return "Left";
            case VK_UP:
                return "Up";
            case VK_RIGHT:
                return "Right";
            case VK_DOWN:
                return "Down";
            case VK_BEGIN:
                return "Begin";

            // modifiers
            case VK_SHIFT:
                return "Shift";
            case VK_CONTROL:
                return "Control";
            case VK_ALT:
                return "Alt";
            case VK_META:
                return "Meta";
            case VK_ALT_GRAPH:
                return "Alt Graph";

            // punctuation
            case VK_COMMA:
                return "Comma";
            case VK_PERIOD:
                return "Period";
            case VK_SLASH:
                return "Slash";
            case VK_SEMICOLON:
                return "Semicolon";
            case VK_EQUALS:
                return "Equals";
            case VK_OPEN_BRACKET:
                return "Open Bracket";
            case VK_BACK_SLASH:
                return "Back Slash";
            case VK_CLOSE_BRACKET:
                return "Close Bracket";

            // numpad numeric keys handled below
            case VK_MULTIPLY:
                return "NumPad *";
            case VK_ADD:
                return "NumPad +";
            case VK_SEPARATOR:
                return "NumPad ,";
            case VK_SUBTRACT:
                return "NumPad -";
            case VK_DECIMAL:
                return "NumPad .";
            case VK_DIVIDE:
                return "NumPad /";
            case VK_DELETE:
                return "Delete";
            case VK_NUM_LOCK:
                return "Num Lock";
            case VK_SCROLL_LOCK:
                return "Scroll Lock";

            case VK_WINDOWS:
                return "Windows";
            case VK_CONTEXT_MENU:
                return "Context Menu";

            case VK_F1:
                return "F1";
            case VK_F2:
                return "F2";
            case VK_F3:
                return "F3";
            case VK_F4:
                return "F4";
            case VK_F5:
                return "F5";
            case VK_F6:
                return "F6";
            case VK_F7:
                return "F7";
            case VK_F8:
                return "F8";
            case VK_F9:
                return "F9";
            case VK_F10:
                return "F10";
            case VK_F11:
                return "F11";
            case VK_F12:
                return "F12";
            case VK_F13:
                return "F13";
            case VK_F14:
                return "F14";
            case VK_F15:
                return "F15";
            case VK_F16:
                return "F16";
            case VK_F17:
                return "F17";
            case VK_F18:
                return "F18";
            case VK_F19:
                return "F19";
            case VK_F20:
                return "F20";
            case VK_F21:
                return "F21";
            case VK_F22:
                return "F22";
            case VK_F23:
                return "F23";
            case VK_F24:
                return "F24";

            case VK_PRINTSCREEN:
                return "Print Screen";
            case VK_INSERT:
                return "Insert";
            case VK_HELP:
                return "Help";
            case VK_BACK_QUOTE:
                return "Back Quote";
            case VK_QUOTE:
                return "Quote";

            case VK_KP_UP:
                return "Up";
            case VK_KP_DOWN:
                return "Down";
            case VK_KP_LEFT:
                return "Left";
            case VK_KP_RIGHT:
                return "Right";

            case VK_DEAD_GRAVE:
                return "Dead Grave";
            case VK_DEAD_ACUTE:
                return "Dead Acute";
            case VK_DEAD_CIRCUMFLEX:
                return "Dead Circumflex";
            case VK_DEAD_TILDE:
                return "Dead Tilde";
            case VK_DEAD_MACRON:
                return "Dead Macron";
            case VK_DEAD_BREVE:
                return "Dead Breve";
            case VK_DEAD_ABOVEDOT:
                return "Dead Above Dot";
            case VK_DEAD_DIAERESIS:
                return "Dead Diaeresis";
            case VK_DEAD_ABOVERING:
                return "Dead Above Ring";
            case VK_DEAD_DOUBLEACUTE:
                return "Dead Double Acute";
            case VK_DEAD_CARON:
                return "Dead Caron";
            case VK_DEAD_CEDILLA:
                return "Dead Cedilla";
            case VK_DEAD_OGONEK:
                return "Dead Ogonek";
            case VK_DEAD_IOTA:
                return "Dead Iota";
            case VK_DEAD_VOICED_SOUND:
                return "Dead Voiced Sound";
            case VK_DEAD_SEMIVOICED_SOUND:
                return "Dead Semivoiced Sound";

            case VK_AMPERSAND:
                return "Ampersand";
            case VK_ASTERISK:
                return "Asterisk";
            case VK_QUOTEDBL:
                return "Double Quote";
            case VK_LESS:
                return "Less";
            case VK_GREATER:
                return "Greater";
            case VK_BRACELEFT:
                return "Left Brace";
            case VK_BRACERIGHT:
                return "Right Brace";
            case VK_AT:
                return "At";
            case VK_COLON:
                return "Colon";
            case VK_CIRCUMFLEX:
                return "Circumflex";
            case VK_DOLLAR:
                return "Dollar";
            case VK_EURO_SIGN:
                return "Euro";
            case VK_EXCLAMATION_MARK:
                return "Exclamation Mark";
            case VK_INVERTED_EXCLAMATION_MARK:
                return "Inverted Exclamation Mark";
            case VK_LEFT_PARENTHESIS:
                return "Left Parenthesis";
            case VK_NUMBER_SIGN:
                return "Number Sign";
            case VK_MINUS:
                return "Minus";
            case VK_PLUS:
                return "Plus";
            case VK_RIGHT_PARENTHESIS:
                return "Right Parenthesis";
            case VK_UNDERSCORE:
                return "Underscore";

            case VK_FINAL:
                return "Final";
            case VK_CONVERT:
                return "Convert";
            case VK_NONCONVERT:
                return "No Convert";
            case VK_ACCEPT:
                return "Accept";
            case VK_MODECHANGE:
                return "Mode Change";
            case VK_KANA:
                return "Kana";
            case VK_KANJI:
                return "Kanji";
            case VK_ALPHANUMERIC:
                return "Alphanumeric";
            case VK_KATAKANA:
                return "Katakana";
            case VK_HIRAGANA:
                return "Hiragana";
            case VK_FULL_WIDTH:
                return "Full-Width";
            case VK_HALF_WIDTH:
                return "Half-Width";
            case VK_ROMAN_CHARACTERS:
                return "Roman Characters";
            case VK_ALL_CANDIDATES:
                return "All Candidates";
            case VK_PREVIOUS_CANDIDATE:
                return "Previous Candidate";
            case VK_CODE_INPUT:
                return "Code Input";
            case VK_JAPANESE_KATAKANA:
                return "Japanese Katakana";
            case VK_JAPANESE_HIRAGANA:
                return "Japanese Hiragana";
            case VK_JAPANESE_ROMAN:
                return "Japanese Roman";
            case VK_KANA_LOCK:
                return "Kana Lock";
            case VK_INPUT_METHOD_ON_OFF:
                return "Input Method On/Off";

            case VK_AGAIN:
                return "Again";
            case VK_UNDO:
                return "Undo";
            case VK_COPY:
                return "Copy";
            case VK_PASTE:
                return "Paste";
            case VK_CUT:
                return "Cut";
            case VK_FIND:
                return "Find";
            case VK_PROPS:
                return "Props";
            case VK_STOP:
                return "Stop";
        }

        if (keyCode >= VK_NUMPAD0 && keyCode <= VK_NUMPAD9) {
            String numpad = "NumPad";
            char c = (char) (keyCode - VK_NUMPAD0 + '0');
            return numpad + "-" + c;
        }

        if ((keyCode & 0x01000000) != 0) {
            return String.valueOf((char) (keyCode ^ 0x01000000));
        }
        String unknown = "Unknown";
        return unknown + " keyCode: 0x" + Integer.toString(keyCode, 16);
    }

 public boolean   isActionKey() {
    switch (keyCode) {
      case VK_HOME:
      case VK_END:
      case VK_PAGE_UP:
      case VK_PAGE_DOWN:
      case VK_UP:
      case VK_DOWN:
      case VK_LEFT:
      case VK_RIGHT:

      case VK_F1:
      case VK_F2:
      case VK_F3:
      case VK_F4:
      case VK_F5:
      case VK_F6:
      case VK_F7:
      case VK_F8:
      case VK_F9:
      case VK_F10:
      case VK_F11:
      case VK_F12:
      case VK_F13:
      case VK_F14:
      case VK_F15:
      case VK_F16:
      case VK_F17:
      case VK_F18:
      case VK_F19:
      case VK_F20:
      case VK_F21:
      case VK_F22:
      case VK_F23:
      case VK_F24:
      case VK_PRINTSCREEN:
      case VK_CAPS_LOCK:
      case VK_PAUSE:
      case VK_INSERT:

      case VK_HELP:
      case VK_WINDOWS:
          return true;
    }
    return false;
 }

    private int keyCode;
    private char keyChar;

    public static final int EVENT_KEY_PRESSED = 300;
    public static final int EVENT_KEY_RELEASED= 301;
    public static final int EVENT_KEY_TYPED   = 302;

    /* Virtual key codes. */

    public static final int VK_ENTER          = '\n';
    public static final int VK_BACK_SPACE     = '\b';
    public static final int VK_TAB            = '\t';
    public static final int VK_CANCEL         = 0x03;
    public static final int VK_CLEAR          = 0x0C;
    public static final int VK_SHIFT          = 0x10;
    public static final int VK_CONTROL        = 0x11;
    public static final int VK_ALT            = 0x12;
    public static final int VK_PAUSE          = 0x13;
    public static final int VK_CAPS_LOCK      = 0x14;
    public static final int VK_ESCAPE         = 0x1B;
    public static final int VK_SPACE          = 0x20;
    public static final int VK_PAGE_UP        = 0x21;
    public static final int VK_PAGE_DOWN      = 0x22;
    public static final int VK_END            = 0x23;
    public static final int VK_HOME           = 0x24;

    /**
     * Constant for the non-numpad <b>left</b> arrow key.
     * @see #VK_KP_LEFT
     */
    public static final int VK_LEFT           = 0x25;

    /**
     * Constant for the non-numpad <b>up</b> arrow key.
     * @see #VK_KP_UP
     */
    public static final int VK_UP             = 0x26;

    /**
     * Constant for the non-numpad <b>right</b> arrow key.
     * @see #VK_KP_RIGHT
     */
    public static final int VK_RIGHT          = 0x27;

    /**
     * Constant for the non-numpad <b>down</b> arrow key.
     * @see #VK_KP_DOWN
     */
    public static final int VK_DOWN           = 0x28;

    /**
     * Constant for the comma key, ","
     */
    public static final int VK_COMMA          = 0x2C;

    /**
     * Constant for the minus key, "-"
     * @since 1.2
     */
    public static final int VK_MINUS          = 0x2D;

    /**
     * Constant for the period key, "."
     */
    public static final int VK_PERIOD         = 0x2E;

    /**
     * Constant for the forward slash key, "/"
     */
    public static final int VK_SLASH          = 0x2F;

    /** VK_0 thru VK_9 are the same as ASCII '0' thru '9' (0x30 - 0x39) */
    public static final int VK_0              = 0x30;
    public static final int VK_1              = 0x31;
    public static final int VK_2              = 0x32;
    public static final int VK_3              = 0x33;
    public static final int VK_4              = 0x34;
    public static final int VK_5              = 0x35;
    public static final int VK_6              = 0x36;
    public static final int VK_7              = 0x37;
    public static final int VK_8              = 0x38;
    public static final int VK_9              = 0x39;

    /**
     * Constant for the semicolon key, ";"
     */
    public static final int VK_SEMICOLON      = 0x3B;

    /**
     * Constant for the equals key, "="
     */
    public static final int VK_EQUALS         = 0x3D;

    /** VK_A thru VK_Z are the same as ASCII 'A' thru 'Z' (0x41 - 0x5A) */
    public static final int VK_A              = 0x41;
    public static final int VK_B              = 0x42;
    public static final int VK_C              = 0x43;
    public static final int VK_D              = 0x44;
    public static final int VK_E              = 0x45;
    public static final int VK_F              = 0x46;
    public static final int VK_G              = 0x47;
    public static final int VK_H              = 0x48;
    public static final int VK_I              = 0x49;
    public static final int VK_J              = 0x4A;
    public static final int VK_K              = 0x4B;
    public static final int VK_L              = 0x4C;
    public static final int VK_M              = 0x4D;
    public static final int VK_N              = 0x4E;
    public static final int VK_O              = 0x4F;
    public static final int VK_P              = 0x50;
    public static final int VK_Q              = 0x51;
    public static final int VK_R              = 0x52;
    public static final int VK_S              = 0x53;
    public static final int VK_T              = 0x54;
    public static final int VK_U              = 0x55;
    public static final int VK_V              = 0x56;
    public static final int VK_W              = 0x57;
    public static final int VK_X              = 0x58;
    public static final int VK_Y              = 0x59;
    public static final int VK_Z              = 0x5A;

    /**
     * Constant for the open bracket key, "["
     */
    public static final int VK_OPEN_BRACKET   = 0x5B;

    /**
     * Constant for the back slash key, "\"
     */
    public static final int VK_BACK_SLASH     = 0x5C;

    /**
     * Constant for the close bracket key, "]"
     */
    public static final int VK_CLOSE_BRACKET  = 0x5D;

    public static final int VK_NUMPAD0        = 0x60;
    public static final int VK_NUMPAD1        = 0x61;
    public static final int VK_NUMPAD2        = 0x62;
    public static final int VK_NUMPAD3        = 0x63;
    public static final int VK_NUMPAD4        = 0x64;
    public static final int VK_NUMPAD5        = 0x65;
    public static final int VK_NUMPAD6        = 0x66;
    public static final int VK_NUMPAD7        = 0x67;
    public static final int VK_NUMPAD8        = 0x68;
    public static final int VK_NUMPAD9        = 0x69;
    public static final int VK_MULTIPLY       = 0x6A;
    public static final int VK_ADD            = 0x6B;

    /** 
     * This constant is obsolete, and is included only for backwards
     * compatibility.
     * @see #VK_SEPARATOR
     */
    public static final int VK_SEPARATER      = 0x6C;

    /** 
     * Constant for the Numpad Separator key. 
     * @since 1.4
     */
    public static final int VK_SEPARATOR      = VK_SEPARATER;

    public static final int VK_SUBTRACT       = 0x6D;
    public static final int VK_DECIMAL        = 0x6E;
    public static final int VK_DIVIDE         = 0x6F;
    public static final int VK_DELETE         = 0x7F; /* ASCII DEL */
    public static final int VK_NUM_LOCK       = 0x90;
    public static final int VK_SCROLL_LOCK    = 0x91;

    /** Constant for the F1 function key. */
    public static final int VK_F1             = 0x70;

    /** Constant for the F2 function key. */
    public static final int VK_F2             = 0x71;

    /** Constant for the F3 function key. */
    public static final int VK_F3             = 0x72;

    /** Constant for the F4 function key. */
    public static final int VK_F4             = 0x73;

    /** Constant for the F5 function key. */
    public static final int VK_F5             = 0x74;

    /** Constant for the F6 function key. */
    public static final int VK_F6             = 0x75;

    /** Constant for the F7 function key. */
    public static final int VK_F7             = 0x76;

    /** Constant for the F8 function key. */
    public static final int VK_F8             = 0x77;

    /** Constant for the F9 function key. */
    public static final int VK_F9             = 0x78;

    /** Constant for the F10 function key. */
    public static final int VK_F10            = 0x79;

    /** Constant for the F11 function key. */
    public static final int VK_F11            = 0x7A;

    /** Constant for the F12 function key. */
    public static final int VK_F12            = 0x7B;

    /**
     * Constant for the F13 function key.
     * @since 1.2
     */
    /* F13 - F24 are used on IBM 3270 keyboard; use random range for constants. */
    public static final int VK_F13            = 0xF000;
 
    /**
     * Constant for the F14 function key.
     * @since 1.2
     */
    public static final int VK_F14            = 0xF001;
 
    /**
     * Constant for the F15 function key.
     * @since 1.2
     */
    public static final int VK_F15            = 0xF002;
 
    /**
     * Constant for the F16 function key.
     * @since 1.2
     */
    public static final int VK_F16            = 0xF003;
 
    /**
     * Constant for the F17 function key.
     * @since 1.2
     */
    public static final int VK_F17            = 0xF004;
 
    /**
     * Constant for the F18 function key.
     * @since 1.2
     */
    public static final int VK_F18            = 0xF005;
 
    /**
     * Constant for the F19 function key.
     * @since 1.2
     */
    public static final int VK_F19            = 0xF006;
 
    /**
     * Constant for the F20 function key.
     * @since 1.2
     */
    public static final int VK_F20            = 0xF007;
 
    /**
     * Constant for the F21 function key.
     * @since 1.2
     */
    public static final int VK_F21            = 0xF008;
 
    /**
     * Constant for the F22 function key.
     * @since 1.2
     */
    public static final int VK_F22            = 0xF009;
 
    /**
     * Constant for the F23 function key.
     * @since 1.2
     */
    public static final int VK_F23            = 0xF00A;
 
    /**
     * Constant for the F24 function key.
     * @since 1.2
     */
    public static final int VK_F24            = 0xF00B;
 
    public static final int VK_PRINTSCREEN    = 0x9A;
    public static final int VK_INSERT         = 0x9B;
    public static final int VK_HELP           = 0x9C;
    public static final int VK_META           = 0x9D;

    public static final int VK_BACK_QUOTE     = 0xC0;
    public static final int VK_QUOTE          = 0xDE;

    /**
     * Constant for the numeric keypad <b>up</b> arrow key.
     * @see #VK_UP
     * @since 1.2
     */
    public static final int VK_KP_UP          = 0xE0;

    /**
     * Constant for the numeric keypad <b>down</b> arrow key.
     * @see #VK_DOWN
     * @since 1.2
     */
    public static final int VK_KP_DOWN        = 0xE1;

    /**
     * Constant for the numeric keypad <b>left</b> arrow key.
     * @see #VK_LEFT
     * @since 1.2
     */
    public static final int VK_KP_LEFT        = 0xE2;

    /**
     * Constant for the numeric keypad <b>right</b> arrow key.
     * @see #VK_RIGHT
     * @since 1.2
     */
    public static final int VK_KP_RIGHT       = 0xE3;
    
    /* For European keyboards */
    /** @since 1.2 */
    public static final int VK_DEAD_GRAVE               = 0x80;
    /** @since 1.2 */
    public static final int VK_DEAD_ACUTE               = 0x81;
    /** @since 1.2 */
    public static final int VK_DEAD_CIRCUMFLEX          = 0x82;
    /** @since 1.2 */
    public static final int VK_DEAD_TILDE               = 0x83;
    /** @since 1.2 */
    public static final int VK_DEAD_MACRON              = 0x84;
    /** @since 1.2 */
    public static final int VK_DEAD_BREVE               = 0x85;
    /** @since 1.2 */
    public static final int VK_DEAD_ABOVEDOT            = 0x86;
    /** @since 1.2 */
    public static final int VK_DEAD_DIAERESIS           = 0x87;
    /** @since 1.2 */
    public static final int VK_DEAD_ABOVERING           = 0x88;
    /** @since 1.2 */
    public static final int VK_DEAD_DOUBLEACUTE         = 0x89;
    /** @since 1.2 */
    public static final int VK_DEAD_CARON               = 0x8a;
    /** @since 1.2 */
    public static final int VK_DEAD_CEDILLA             = 0x8b;
    /** @since 1.2 */
    public static final int VK_DEAD_OGONEK              = 0x8c;
    /** @since 1.2 */
    public static final int VK_DEAD_IOTA                = 0x8d;
    /** @since 1.2 */
    public static final int VK_DEAD_VOICED_SOUND        = 0x8e;
    /** @since 1.2 */
    public static final int VK_DEAD_SEMIVOICED_SOUND    = 0x8f;

    /** @since 1.2 */
    public static final int VK_AMPERSAND                = 0x96;
    /** @since 1.2 */
    public static final int VK_ASTERISK                 = 0x97;
    /** @since 1.2 */
    public static final int VK_QUOTEDBL                 = 0x98;
    /** @since 1.2 */
    public static final int VK_LESS                     = 0x99;

    /** @since 1.2 */
    public static final int VK_GREATER                  = 0xa0;
    /** @since 1.2 */
    public static final int VK_BRACELEFT                = 0xa1;
    /** @since 1.2 */
    public static final int VK_BRACERIGHT               = 0xa2;

    /**
     * Constant for the "@" key.
     * @since 1.2
     */
    public static final int VK_AT                       = 0x0200;
 
    /**
     * Constant for the ":" key.
     * @since 1.2
     */
    public static final int VK_COLON                    = 0x0201;
 
    /**
     * Constant for the "^" key.
     * @since 1.2
     */
    public static final int VK_CIRCUMFLEX               = 0x0202;
 
    /**
     * Constant for the "$" key.
     * @since 1.2
     */
    public static final int VK_DOLLAR                   = 0x0203;
 
    /**
     * Constant for the Euro currency sign key.
     * @since 1.2
     */
    public static final int VK_EURO_SIGN                = 0x0204;
 
    /**
     * Constant for the "!" key.
     * @since 1.2
     */
    public static final int VK_EXCLAMATION_MARK         = 0x0205;
 
    /**
     * Constant for the inverted exclamation mark key.
     * @since 1.2
     */
    public static final int VK_INVERTED_EXCLAMATION_MARK = 0x0206;
 
    /**
     * Constant for the "(" key.
     * @since 1.2
     */
    public static final int VK_LEFT_PARENTHESIS         = 0x0207;
 
    /**
     * Constant for the "#" key.
     * @since 1.2
     */
    public static final int VK_NUMBER_SIGN              = 0x0208;
 
    /**
     * Constant for the "+" key.
     * @since 1.2
     */
    public static final int VK_PLUS                     = 0x0209;
 
    /**
     * Constant for the ")" key.
     * @since 1.2
     */
    public static final int VK_RIGHT_PARENTHESIS        = 0x020A;
 
    /**
     * Constant for the "_" key.
     * @since 1.2
     */
    public static final int VK_UNDERSCORE               = 0x020B;
 
    /**
     * Constant for the Microsoft Windows "Windows" key.
     * It is used for both the left and right version of the key.  
     * @see #getKeyLocation()
     * @since 1.5
     */
    public static final int VK_WINDOWS                  = 0x020C;
 
    /**
     * Constant for the Microsoft Windows Context Menu key.
     * @since 1.5
     */
    public static final int VK_CONTEXT_MENU             = 0x020D;
 
    /* for input method support on Asian Keyboards */

    /* not clear what this means - listed in Microsoft Windows API */
    public static final int VK_FINAL                    = 0x0018;
    
    /** Constant for the Convert function key. */
    /* Japanese PC 106 keyboard, Japanese Solaris keyboard: henkan */
    public static final int VK_CONVERT                  = 0x001C;

    /** Constant for the Don't Convert function key. */
    /* Japanese PC 106 keyboard: muhenkan */
    public static final int VK_NONCONVERT               = 0x001D;
    
    /** Constant for the Accept or Commit function key. */
    /* Japanese Solaris keyboard: kakutei */
    public static final int VK_ACCEPT                   = 0x001E;

    /* not clear what this means - listed in Microsoft Windows API */
    public static final int VK_MODECHANGE               = 0x001F;

    /* replaced by VK_KANA_LOCK for Microsoft Windows and Solaris; 
       might still be used on other platforms */
    public static final int VK_KANA                     = 0x0015;

    /* replaced by VK_INPUT_METHOD_ON_OFF for Microsoft Windows and Solaris; 
       might still be used for other platforms */
    public static final int VK_KANJI                    = 0x0019;

    /**
     * Constant for the Alphanumeric function key.
     * @since 1.2
     */
    /* Japanese PC 106 keyboard: eisuu */
    public static final int VK_ALPHANUMERIC             = 0x00F0;
 
    /**
     * Constant for the Katakana function key.
     * @since 1.2
     */
    /* Japanese PC 106 keyboard: katakana */
    public static final int VK_KATAKANA                 = 0x00F1;
 
    /**
     * Constant for the Hiragana function key.
     * @since 1.2
     */
    /* Japanese PC 106 keyboard: hiragana */
    public static final int VK_HIRAGANA                 = 0x00F2;
 
    /**
     * Constant for the Full-Width Characters function key.
     * @since 1.2
     */
    /* Japanese PC 106 keyboard: zenkaku */
    public static final int VK_FULL_WIDTH               = 0x00F3;
 
    /**
     * Constant for the Half-Width Characters function key.
     * @since 1.2
     */
    /* Japanese PC 106 keyboard: hankaku */
    public static final int VK_HALF_WIDTH               = 0x00F4;
 
    /**
     * Constant for the Roman Characters function key.
     * @since 1.2
     */
    /* Japanese PC 106 keyboard: roumaji */
    public static final int VK_ROMAN_CHARACTERS         = 0x00F5;
 
    /**
     * Constant for the All Candidates function key.
     * @since 1.2
     */
    /* Japanese PC 106 keyboard - VK_CONVERT + ALT: zenkouho */
    public static final int VK_ALL_CANDIDATES           = 0x0100;
 
    /**
     * Constant for the Previous Candidate function key.
     * @since 1.2
     */
    /* Japanese PC 106 keyboard - VK_CONVERT + SHIFT: maekouho */
    public static final int VK_PREVIOUS_CANDIDATE       = 0x0101;
 
    /**
     * Constant for the Code Input function key.
     * @since 1.2
     */
    /* Japanese PC 106 keyboard - VK_ALPHANUMERIC + ALT: kanji bangou */
    public static final int VK_CODE_INPUT               = 0x0102;
 
    /**
     * Constant for the Japanese-Katakana function key.
     * This key switches to a Japanese input method and selects its Katakana input mode.
     * @since 1.2
     */
    /* Japanese Macintosh keyboard - VK_JAPANESE_HIRAGANA + SHIFT */
    public static final int VK_JAPANESE_KATAKANA        = 0x0103;
 
    /**
     * Constant for the Japanese-Hiragana function key.
     * This key switches to a Japanese input method and selects its Hiragana input mode.
     * @since 1.2
     */
    /* Japanese Macintosh keyboard */
    public static final int VK_JAPANESE_HIRAGANA        = 0x0104;
 
    /**
     * Constant for the Japanese-Roman function key.
     * This key switches to a Japanese input method and selects its Roman-Direct input mode.
     * @since 1.2
     */
    /* Japanese Macintosh keyboard */
    public static final int VK_JAPANESE_ROMAN           = 0x0105;

    /**
     * Constant for the locking Kana function key.
     * This key locks the keyboard into a Kana layout.
     * @since 1.3
     */
    /* Japanese PC 106 keyboard with special Windows driver - eisuu + Control; Japanese Solaris keyboard: kana */
    public static final int VK_KANA_LOCK                = 0x0106;

    /**
     * Constant for the input method on/off key.
     * @since 1.3
     */
    /* Japanese PC 106 keyboard: kanji. Japanese Solaris keyboard: nihongo */
    public static final int VK_INPUT_METHOD_ON_OFF      = 0x0107;

    /* for Sun keyboards */
    /** @since 1.2 */
    public static final int VK_CUT                      = 0xFFD1;
    /** @since 1.2 */
    public static final int VK_COPY                     = 0xFFCD;
    /** @since 1.2 */
    public static final int VK_PASTE                    = 0xFFCF;
    /** @since 1.2 */
    public static final int VK_UNDO                     = 0xFFCB;
    /** @since 1.2 */
    public static final int VK_AGAIN                    = 0xFFC9;
    /** @since 1.2 */
    public static final int VK_FIND                     = 0xFFD0;
    /** @since 1.2 */
    public static final int VK_PROPS                    = 0xFFCA;
    /** @since 1.2 */
    public static final int VK_STOP                     = 0xFFC8;
    
    /**
     * Constant for the Compose function key.
     * @since 1.2
     */
    public static final int VK_COMPOSE                  = 0xFF20;
 
    /**
     * Constant for the AltGraph function key.
     * @since 1.2
     */
    public static final int VK_ALT_GRAPH                = 0xFF7E;

    /**
     * Constant for the Begin key.
     * @since 1.5
     */
    public static final int VK_BEGIN                    = 0xFF58;

    /**
     * This value is used to indicate that the keyCode is unknown.
     * KEY_TYPED events do not have a keyCode value; this value 
     * is used instead.  
     */
    public static final int VK_UNDEFINED      = 0x0;
}

