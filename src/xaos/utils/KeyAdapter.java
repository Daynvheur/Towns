package xaos.utils;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Maps LWJGL 2 key codes to GLFW 3 key codes and provides compatible API.
 * LWJGL 2 key codes are based on ASCII values for letters (KEY_A=0x41, KEY_B=0x42, etc.)
 * GLFW 3 uses its own GLFW_KEY_* constants.
 */
public final class KeyAdapter {

    private KeyAdapter() {}

    // LWJGL 2 key constants (for reference)
    public static final int KEY_NONE = 0x00;
    public static final int KEY_A = 0x41;
    public static final int KEY_B = 0x42;
    public static final int KEY_C = 0x43;
    public static final int KEY_D = 0x44;
    public static final int KEY_E = 0x45;
    public static final int KEY_F = 0x46;
    public static final int KEY_G = 0x47;
    public static final int KEY_H = 0x48;
    public static final int KEY_I = 0x49;
    public static final int KEY_J = 0x4A;
    public static final int KEY_K = 0x4B;
    public static final int KEY_L = 0x4C;
    public static final int KEY_M = 0x4D;
    public static final int KEY_N = 0x4E;
    public static final int KEY_O = 0x4F;
    public static final int KEY_P = 0x50;
    public static final int KEY_Q = 0x51;
    public static final int KEY_R = 0x52;
    public static final int KEY_S = 0x53;
    public static final int KEY_T = 0x54;
    public static final int KEY_U = 0x55;
    public static final int KEY_V = 0x56;
    public static final int KEY_W = 0x57;
    public static final int KEY_X = 0x58;
    public static final int KEY_Y = 0x59;
    public static final int KEY_Z = 0x5A;
    public static final int KEY_0 = 0x30;
    public static final int KEY_1 = 0x31;
    public static final int KEY_2 = 0x32;
    public static final int KEY_3 = 0x33;
    public static final int KEY_4 = 0x34;
    public static final int KEY_5 = 0x35;
    public static final int KEY_6 = 0x36;
    public static final int KEY_7 = 0x37;
    public static final int KEY_8 = 0x38;
    public static final int KEY_9 = 0x39;

    // Special keys
    public static final int KEY_ESCAPE = 0x01;
    public static final int KEY_LBUTTON = 0x02;
    public static final int KEY_RBUTTON = 0x03;
    public static final int KEY_CANCEL = 0x04;
    public static final int KEY_MBUTTON = 0x04;
    public static final int KEY_XBUTTON1 = 0x05;
    public static final int KEY_XBUTTON2 = 0x06;
    public static final int KEY_BACK = 0x08;
    public static final int KEY_TAB = 0x09;
    public static final int KEY_LINEFEED = 0x0A;
    public static final int KEY_CLEAR = 0x0C;
    public static final int KEY_RETURN = 0x0D;
    public static final int KEY_PAUSE = 0x13;
    public static final int KEY_CAPITAL = 0x14;
    public static final int KEY_KANA = 0x15;
    public static final int KEY_HANGUL = 0x15;
    public static final int KEY_JUNJA = 0x17;
    public static final int KEY_FINAL = 0x18;
    public static final int KEY_HANJA = 0x19;
    public static final int KEY_KANJI = 0x19;
    public static final int KEY_ESCAPE2 = 0x1B;
    public static final int KEY_SPACE = 0x20;
    public static final int KEY_PRIOR = 0x21;
    public static final int KEY_NEXT = 0x22;
    public static final int KEY_END = 0x23;
    public static final int KEY_HOME = 0x24;
    public static final int KEY_LEFT = 0x25;
    public static final int KEY_UP = 0x26;
    public static final int KEY_RIGHT = 0x27;
    public static final int KEY_DOWN = 0x28;
    public static final int KEY_SELECT = 0x29;
    public static final int KEY_PRINT = 0x2A;
    public static final int KEY_EXECUTE = 0x2B;
    public static final int KEY_SNAPSHOT = 0x2C;
    public static final int KEY_INSERT = 0x2D;
    public static final int KEY_DELETE = 0x2E;
    public static final int KEY_PERIOD = 0x2E;
    public static final int KEY_SLASH = 0x2F;
    public static final int KEY_HELP = 0x2F;
    public static final int KEY_LWIN = 0x5B;
    public static final int KEY_RWIN = 0x5C;
    public static final int KEY_APPS = 0x5D;
    public static final int KEY_SLEEP = 0x5F;
    public static final int KEY_NUMPAD0 = 0x60;
    public static final int KEY_NUMPAD1 = 0x61;
    public static final int KEY_NUMPAD2 = 0x62;
    public static final int KEY_NUMPAD3 = 0x63;
    public static final int KEY_NUMPAD4 = 0x64;
    public static final int KEY_NUMPAD5 = 0x65;
    public static final int KEY_NUMPAD6 = 0x66;
    public static final int KEY_NUMPAD7 = 0x67;
    public static final int KEY_NUMPAD8 = 0x68;
    public static final int KEY_NUMPAD9 = 0x69;
    public static final int KEY_MULTIPLY = 0x6A;
    public static final int KEY_ADD = 0x6B;
    public static final int KEY_SEPARATOR = 0x6C;
    public static final int KEY_SUBTRACT = 0x6D;
    public static final int KEY_DECIMAL = 0x6E;
    public static final int KEY_DIVIDE = 0x6F;
    public static final int KEY_F1 = 0x70;
    public static final int KEY_F2 = 0x71;
    public static final int KEY_F3 = 0x72;
    public static final int KEY_F4 = 0x73;
    public static final int KEY_F5 = 0x74;
    public static final int KEY_F6 = 0x75;
    public static final int KEY_F7 = 0x76;
    public static final int KEY_F8 = 0x77;
    public static final int KEY_F9 = 0x78;
    public static final int KEY_F10 = 0x79;
    public static final int KEY_F11 = 0x7A;
    public static final int KEY_F12 = 0x7B;
    public static final int KEY_F13 = 0x7C;
    public static final int KEY_F14 = 0x7D;
    public static final int KEY_F15 = 0x7E;
    public static final int KEY_F16 = 0x7F;
    public static final int KEY_F17 = 0x80;
    public static final int KEY_F18 = 0x81;
    public static final int KEY_F19 = 0x82;
    public static final int KEY_F20 = 0x83;
    public static final int KEY_F21 = 0x84;
    public static final int KEY_F22 = 0x85;
    public static final int KEY_F23 = 0x86;
    public static final int KEY_F24 = 0x87;
    public static final int KEY_NUMLOCK = 0x90;
    public static final int KEY_SCROLL = 0x91;
    public static final int KEY_LSHIFT = 0xA0;
    public static final int KEY_RSHIFT = 0xA1;
    public static final int KEY_LCONTROL = 0xA2;
    public static final int KEY_RCONTROL = 0xA3;
    public static final int KEY_LMENU = 0xA4;
    public static final int KEY_RMENU = 0xA5;

    // FN constants from UtilsKeyboard (for compatibility)
    public static final int FN_NONE = -1;
    public static final int FN_UP = 0;
    public static final int FN_DOWN = 1;
    public static final int FN_LEFT = 2;
    public static final int FN_RIGHT = 3;
    public static final int FN_SHOW_MISSION = 4;
    public static final int FN_SHOW_STOCK = 5;
    public static final int FN_SHOW_PRIORITIES = 6;
    public static final int FN_SHOW_TRADE = 7;
    public static final int FN_TOGGLE_FULLSCREEN = 8;
    public static final int FN_SPEED_DOWN = 9;
    public static final int FN_SPEED_UP = 10;
    public static final int FN_TOGGLE_GRID = 11;
    public static final int FN_TOGGLE_FLAT_MOUSE = 12;
    public static final int FN_PAUSE = 13;
    public static final int FN_LEVEL_DOWN = 14;
    public static final int FN_LEVEL_UP = 15;
    public static final int FN_NEXT_CITIZEN = 16;
    public static final int FN_PREVIOUS_CITIZEN = 17;
    public static final int FN_NEXT_SOLDIER = 18;
    public static final int FN_PREVIOUS_SOLDIER = 19;
    public static final int FN_NEXT_HERO = 20;
    public static final int FN_PREVIOUS_HERO = 21;
    public static final int FN_TOGGLE_MINIBLOCKS = 22;
    public static final int FN_BOT_1 = 23;
    public static final int FN_BOT_2 = 24;
    public static final int FN_BOT_3 = 25;
    public static final int FN_BOT_4 = 26;
    public static final int FN_BOT_5 = 27;
    public static final int FN_BOT_6 = 28;
    public static final int FN_BOT_7 = 29;
    public static final int FN_BOT_8 = 30;
    public static final int FN_BOT_9 = 31;
    public static final int FN_BOT_10 = 32;
    public static final int FN_TOGGLE_3D_MOUSE = 33;
    public static final int FN_TOGGLE_HIDE_UI = 34;
    public static final int FN_SCREENSHOT = 35;
    public static final int FN_TOGGLE_ITEM_BUILD_FACE = 36;

    // ==================== LWJGL 2 -> GLFW 3 mapping ====================

    /**
     * Convert LWJGL 2 key code to GLFW 3 key code.
     */
    public static int toGLFW(int lwjgl2Key) {
        switch (lwjgl2Key) {
            // Letters
            case KEY_A: return GLFW_KEY_A;
            case KEY_B: return GLFW_KEY_B;
            case KEY_C: return GLFW_KEY_C;
            case KEY_D: return GLFW_KEY_D;
            case KEY_E: return GLFW_KEY_E;
            case KEY_F: return GLFW_KEY_F;
            case KEY_G: return GLFW_KEY_G;
            case KEY_H: return GLFW_KEY_H;
            case KEY_I: return GLFW_KEY_I;
            case KEY_J: return GLFW_KEY_J;
            case KEY_K: return GLFW_KEY_K;
            case KEY_L: return GLFW_KEY_L;
            case KEY_M: return GLFW_KEY_M;
            case KEY_N: return GLFW_KEY_N;
            case KEY_O: return GLFW_KEY_O;
            case KEY_P: return GLFW_KEY_P;
            case KEY_Q: return GLFW_KEY_Q;
            case KEY_R: return GLFW_KEY_R;
            case KEY_S: return GLFW_KEY_S;
            case KEY_T: return GLFW_KEY_T;
            case KEY_U: return GLFW_KEY_U;
            case KEY_V: return GLFW_KEY_V;
            case KEY_W: return GLFW_KEY_W;
            case KEY_X: return GLFW_KEY_X;
            case KEY_Y: return GLFW_KEY_Y;
            case KEY_Z: return GLFW_KEY_Z;
            // Numbers
            case KEY_0: return GLFW_KEY_0;
            case KEY_1: return GLFW_KEY_1;
            case KEY_2: return GLFW_KEY_2;
            case KEY_3: return GLFW_KEY_3;
            case KEY_4: return GLFW_KEY_4;
            case KEY_5: return GLFW_KEY_5;
            case KEY_6: return GLFW_KEY_6;
            case KEY_7: return GLFW_KEY_7;
            case KEY_8: return GLFW_KEY_8;
            case KEY_9: return GLFW_KEY_9;
            // Special keys
            case KEY_ESCAPE: return GLFW_KEY_ESCAPE;
            case KEY_BACK: return GLFW_KEY_BACKSPACE;
            case KEY_TAB: return GLFW_KEY_TAB;
            case KEY_RETURN: return GLFW_KEY_ENTER;
            case KEY_PAUSE: return GLFW_KEY_PAUSE;
            case KEY_CAPITAL: return GLFW_KEY_CAPS_LOCK;
            case KEY_SPACE: return GLFW_KEY_SPACE;
            case KEY_PRIOR: return GLFW_KEY_PAGE_UP;
            case KEY_NEXT: return GLFW_KEY_PAGE_DOWN;
            case KEY_END: return GLFW_KEY_END;
            case KEY_HOME: return GLFW_KEY_HOME;
            case KEY_LEFT: return GLFW_KEY_LEFT;
            case KEY_UP: return GLFW_KEY_UP;
            case KEY_RIGHT: return GLFW_KEY_RIGHT;
            case KEY_DOWN: return GLFW_KEY_DOWN;
            case KEY_INSERT: return GLFW_KEY_INSERT;
            case KEY_DELETE: return GLFW_KEY_DELETE;
            case KEY_LWIN: return GLFW_KEY_LEFT_SUPER;
            case KEY_RWIN: return GLFW_KEY_RIGHT_SUPER;
            case KEY_NUMPAD0: return GLFW_KEY_KP_0;
            case KEY_NUMPAD1: return GLFW_KEY_KP_1;
            case KEY_NUMPAD2: return GLFW_KEY_KP_2;
            case KEY_NUMPAD3: return GLFW_KEY_KP_3;
            case KEY_NUMPAD4: return GLFW_KEY_KP_4;
            case KEY_NUMPAD5: return GLFW_KEY_KP_5;
            case KEY_NUMPAD6: return GLFW_KEY_KP_6;
            case KEY_NUMPAD7: return GLFW_KEY_KP_7;
            case KEY_NUMPAD8: return GLFW_KEY_KP_8;
            case KEY_NUMPAD9: return GLFW_KEY_KP_9;
            case KEY_MULTIPLY: return GLFW_KEY_KP_MULTIPLY;
            case KEY_ADD: return GLFW_KEY_KP_ADD;
            case KEY_SEPARATOR: return GLFW_KEY_UNKNOWN;
            case KEY_SUBTRACT: return GLFW_KEY_KP_SUBTRACT;
            case KEY_DECIMAL: return GLFW_KEY_KP_DECIMAL;
            case KEY_DIVIDE: return GLFW_KEY_KP_DIVIDE;
            case KEY_F1: return GLFW_KEY_F1;
            case KEY_F2: return GLFW_KEY_F2;
            case KEY_F3: return GLFW_KEY_F3;
            case KEY_F4: return GLFW_KEY_F4;
            case KEY_F5: return GLFW_KEY_F5;
            case KEY_F6: return GLFW_KEY_F6;
            case KEY_F7: return GLFW_KEY_F7;
            case KEY_F8: return GLFW_KEY_F8;
            case KEY_F9: return GLFW_KEY_F9;
            case KEY_F10: return GLFW_KEY_F10;
            case KEY_F11: return GLFW_KEY_F11;
            case KEY_F12: return GLFW_KEY_F12;
            case KEY_F13: return GLFW_KEY_F13;
            case KEY_F14: return GLFW_KEY_F14;
            case KEY_F15: return GLFW_KEY_F15;
            case KEY_F16: return GLFW_KEY_F16;
            case KEY_F17: return GLFW_KEY_F17;
            case KEY_F18: return GLFW_KEY_F18;
            case KEY_F19: return GLFW_KEY_F19;
            case KEY_F20: return GLFW_KEY_F20;
            case KEY_F21: return GLFW_KEY_F21;
            case KEY_F22: return GLFW_KEY_F22;
            case KEY_F23: return GLFW_KEY_F23;
            case KEY_F24: return GLFW_KEY_F24;
            case KEY_NUMLOCK: return GLFW_KEY_NUM_LOCK;
            case KEY_SCROLL: return GLFW_KEY_SCROLL_LOCK;
            case KEY_LSHIFT: return GLFW_KEY_LEFT_SHIFT;
            case KEY_RSHIFT: return GLFW_KEY_RIGHT_SHIFT;
            case KEY_LCONTROL: return GLFW_KEY_LEFT_CONTROL;
            case KEY_RCONTROL: return GLFW_KEY_RIGHT_CONTROL;
            case KEY_LMENU: return GLFW_KEY_LEFT_ALT;
            case KEY_RMENU: return GLFW_KEY_RIGHT_ALT;
            default: return lwjgl2Key; // Pass through unknown keys
        }
    }

    /**
     * Convert GLFW 3 key code to LWJGL 2 key code.
     */
    public static int toLWJGL2(int glfwKey) {
        switch (glfwKey) {
            case GLFW_KEY_A: return KEY_A;
            case GLFW_KEY_B: return KEY_B;
            case GLFW_KEY_C: return KEY_C;
            case GLFW_KEY_D: return KEY_D;
            case GLFW_KEY_E: return KEY_E;
            case GLFW_KEY_F: return KEY_F;
            case GLFW_KEY_G: return KEY_G;
            case GLFW_KEY_H: return KEY_H;
            case GLFW_KEY_I: return KEY_I;
            case GLFW_KEY_J: return KEY_J;
            case GLFW_KEY_K: return KEY_K;
            case GLFW_KEY_L: return KEY_L;
            case GLFW_KEY_M: return KEY_M;
            case GLFW_KEY_N: return KEY_N;
            case GLFW_KEY_O: return KEY_O;
            case GLFW_KEY_P: return KEY_P;
            case GLFW_KEY_Q: return KEY_Q;
            case GLFW_KEY_R: return KEY_R;
            case GLFW_KEY_S: return KEY_S;
            case GLFW_KEY_T: return KEY_T;
            case GLFW_KEY_U: return KEY_U;
            case GLFW_KEY_V: return KEY_V;
            case GLFW_KEY_W: return KEY_W;
            case GLFW_KEY_X: return KEY_X;
            case GLFW_KEY_Y: return KEY_Y;
            case GLFW_KEY_Z: return KEY_Z;
            case GLFW_KEY_0: return KEY_0;
            case GLFW_KEY_1: return KEY_1;
            case GLFW_KEY_2: return KEY_2;
            case GLFW_KEY_3: return KEY_3;
            case GLFW_KEY_4: return KEY_4;
            case GLFW_KEY_5: return KEY_5;
            case GLFW_KEY_6: return KEY_6;
            case GLFW_KEY_7: return KEY_7;
            case GLFW_KEY_8: return KEY_8;
            case GLFW_KEY_9: return KEY_9;
            case GLFW_KEY_ESCAPE: return KEY_ESCAPE;
            case GLFW_KEY_BACKSPACE: return KEY_BACK;
            case GLFW_KEY_TAB: return KEY_TAB;
            case GLFW_KEY_ENTER: return KEY_RETURN;
            case GLFW_KEY_PAUSE: return KEY_PAUSE;
            case GLFW_KEY_CAPS_LOCK: return KEY_CAPITAL;
            case GLFW_KEY_SPACE: return KEY_SPACE;
            case GLFW_KEY_PAGE_UP: return KEY_PRIOR;
            case GLFW_KEY_PAGE_DOWN: return KEY_NEXT;
            case GLFW_KEY_END: return KEY_END;
            case GLFW_KEY_HOME: return KEY_HOME;
            case GLFW_KEY_LEFT: return KEY_LEFT;
            case GLFW_KEY_UP: return KEY_UP;
            case GLFW_KEY_RIGHT: return KEY_RIGHT;
            case GLFW_KEY_DOWN: return KEY_DOWN;
            case GLFW_KEY_INSERT: return KEY_INSERT;
            case GLFW_KEY_DELETE: return KEY_DELETE;
            case GLFW_KEY_LEFT_SUPER: return KEY_LWIN;
            case GLFW_KEY_RIGHT_SUPER: return KEY_RWIN;
            case GLFW_KEY_KP_0: return KEY_NUMPAD0;
            case GLFW_KEY_KP_1: return KEY_NUMPAD1;
            case GLFW_KEY_KP_2: return KEY_NUMPAD2;
            case GLFW_KEY_KP_3: return KEY_NUMPAD3;
            case GLFW_KEY_KP_4: return KEY_NUMPAD4;
            case GLFW_KEY_KP_5: return KEY_NUMPAD5;
            case GLFW_KEY_KP_6: return KEY_NUMPAD6;
            case GLFW_KEY_KP_7: return KEY_NUMPAD7;
            case GLFW_KEY_KP_8: return KEY_NUMPAD8;
            case GLFW_KEY_KP_9: return KEY_NUMPAD9;
            case GLFW_KEY_KP_MULTIPLY: return KEY_MULTIPLY;
            case GLFW_KEY_KP_ADD: return KEY_ADD;
            case GLFW_KEY_KP_SUBTRACT: return KEY_SUBTRACT;
            case GLFW_KEY_KP_DECIMAL: return KEY_DECIMAL;
            case GLFW_KEY_KP_DIVIDE: return KEY_DIVIDE;
            case GLFW_KEY_F1: return KEY_F1;
            case GLFW_KEY_F2: return KEY_F2;
            case GLFW_KEY_F3: return KEY_F3;
            case GLFW_KEY_F4: return KEY_F4;
            case GLFW_KEY_F5: return KEY_F5;
            case GLFW_KEY_F6: return KEY_F6;
            case GLFW_KEY_F7: return KEY_F7;
            case GLFW_KEY_F8: return KEY_F8;
            case GLFW_KEY_F9: return KEY_F9;
            case GLFW_KEY_F10: return KEY_F10;
            case GLFW_KEY_F11: return KEY_F11;
            case GLFW_KEY_F12: return KEY_F12;
            case GLFW_KEY_F13: return KEY_F13;
            case GLFW_KEY_F14: return KEY_F14;
            case GLFW_KEY_F15: return KEY_F15;
            case GLFW_KEY_F16: return KEY_F16;
            case GLFW_KEY_F17: return KEY_F17;
            case GLFW_KEY_F18: return KEY_F18;
            case GLFW_KEY_F19: return KEY_F19;
            case GLFW_KEY_F20: return KEY_F20;
            case GLFW_KEY_F21: return KEY_F21;
            case GLFW_KEY_F22: return KEY_F22;
            case GLFW_KEY_F23: return KEY_F23;
            case GLFW_KEY_F24: return KEY_F24;
            case GLFW_KEY_NUM_LOCK: return KEY_NUMLOCK;
            case GLFW_KEY_SCROLL_LOCK: return KEY_SCROLL;
            case GLFW_KEY_LEFT_SHIFT: return KEY_LSHIFT;
            case GLFW_KEY_RIGHT_SHIFT: return KEY_RSHIFT;
            case GLFW_KEY_LEFT_CONTROL: return KEY_LCONTROL;
            case GLFW_KEY_RIGHT_CONTROL: return KEY_RCONTROL;
            case GLFW_KEY_LEFT_ALT: return KEY_LMENU;
            case GLFW_KEY_RIGHT_ALT: return KEY_RMENU;
            default: return glfwKey; // Pass through unknown keys
        }
    }

    /**
     * Get key name for an LWJGL 2 key code (compatible with Keyboard.getKeyName()).
     */
    public static String getKeyName(int key) {
        switch (key) {
            case KEY_NONE: return "NONE";
            case KEY_A: return "A";
            case KEY_B: return "B";
            case KEY_C: return "C";
            case KEY_D: return "D";
            case KEY_E: return "E";
            case KEY_F: return "F";
            case KEY_G: return "G";
            case KEY_H: return "H";
            case KEY_I: return "I";
            case KEY_J: return "J";
            case KEY_K: return "K";
            case KEY_L: return "L";
            case KEY_M: return "M";
            case KEY_N: return "N";
            case KEY_O: return "O";
            case KEY_P: return "P";
            case KEY_Q: return "Q";
            case KEY_R: return "R";
            case KEY_S: return "S";
            case KEY_T: return "T";
            case KEY_U: return "U";
            case KEY_V: return "V";
            case KEY_W: return "W";
            case KEY_X: return "X";
            case KEY_Y: return "Y";
            case KEY_Z: return "Z";
            case KEY_0: return "0";
            case KEY_1: return "1";
            case KEY_2: return "2";
            case KEY_3: return "3";
            case KEY_4: return "4";
            case KEY_5: return "5";
            case KEY_6: return "6";
            case KEY_7: return "7";
            case KEY_8: return "8";
            case KEY_9: return "9";
            case KEY_ESCAPE: return "ESCAPE";
            case KEY_BACK: return "BACK";
            case KEY_TAB: return "TAB";
            case KEY_RETURN: return "RETURN";
            case KEY_PAUSE: return "PAUSE";
            case KEY_CAPITAL: return "CAPITAL";
            case KEY_SPACE: return "SPACE";
            case KEY_PRIOR: return "PRIOR";
            case KEY_NEXT: return "NEXT";
            case KEY_END: return "END";
            case KEY_HOME: return "HOME";
            case KEY_LEFT: return "LEFT";
            case KEY_UP: return "UP";
            case KEY_RIGHT: return "RIGHT";
            case KEY_DOWN: return "DOWN";
            case KEY_INSERT: return "INSERT";
            case KEY_DELETE: return "DELETE";
            case KEY_LWIN: return "LWIN";
            case KEY_RWIN: return "RWIN";
            case KEY_NUMPAD0: return "NUMPAD0";
            case KEY_NUMPAD1: return "NUMPAD1";
            case KEY_NUMPAD2: return "NUMPAD2";
            case KEY_NUMPAD3: return "NUMPAD3";
            case KEY_NUMPAD4: return "NUMPAD4";
            case KEY_NUMPAD5: return "NUMPAD5";
            case KEY_NUMPAD6: return "NUMPAD6";
            case KEY_NUMPAD7: return "NUMPAD7";
            case KEY_NUMPAD8: return "NUMPAD8";
            case KEY_NUMPAD9: return "NUMPAD9";
            case KEY_MULTIPLY: return "MULTIPLY";
            case KEY_ADD: return "ADD";
            case KEY_SEPARATOR: return "SEPARATOR";
            case KEY_SUBTRACT: return "SUBTRACT";
            case KEY_DECIMAL: return "DECIMAL";
            case KEY_DIVIDE: return "DIVIDE";
            case KEY_F1: return "F1";
            case KEY_F2: return "F2";
            case KEY_F3: return "F3";
            case KEY_F4: return "F4";
            case KEY_F5: return "F5";
            case KEY_F6: return "F6";
            case KEY_F7: return "F7";
            case KEY_F8: return "F8";
            case KEY_F9: return "F9";
            case KEY_F10: return "F10";
            case KEY_F11: return "F11";
            case KEY_F12: return "F12";
            case KEY_F13: return "F13";
            case KEY_F14: return "F14";
            case KEY_F15: return "F15";
            case KEY_F16: return "F16";
            case KEY_F17: return "F17";
            case KEY_F18: return "F18";
            case KEY_F19: return "F19";
            case KEY_F20: return "F20";
            case KEY_F21: return "F21";
            case KEY_F22: return "F22";
            case KEY_F23: return "F23";
            case KEY_F24: return "F24";
            case KEY_NUMLOCK: return "NUMLOCK";
            case KEY_SCROLL: return "SCROLL";
            case KEY_LSHIFT: return "LSHIFT";
            case KEY_RSHIFT: return "RSHIFT";
            case KEY_LCONTROL: return "LCONTROL";
            case KEY_RCONTROL: return "RCONTROL";
            case KEY_LMENU: return "LMENU";
            case KEY_RMENU: return "RMENU";
            default: return "KEY_" + key;
        }
    }

    /**
     * Get key index (code) from a key name (compatible with Keyboard.getKeyIndex()).
     */
    public static int getKeyIndex(String name) {
        if (name == null) return KEY_NONE;
        name = name.toUpperCase();
        switch (name) {
            case "NONE": return KEY_NONE;
            case "A": return KEY_A;
            case "B": return KEY_B;
            case "C": return KEY_C;
            case "D": return KEY_D;
            case "E": return KEY_E;
            case "F": return KEY_F;
            case "G": return KEY_G;
            case "H": return KEY_H;
            case "I": return KEY_I;
            case "J": return KEY_J;
            case "K": return KEY_K;
            case "L": return KEY_L;
            case "M": return KEY_M;
            case "N": return KEY_N;
            case "O": return KEY_O;
            case "P": return KEY_P;
            case "Q": return KEY_Q;
            case "R": return KEY_R;
            case "S": return KEY_S;
            case "T": return KEY_T;
            case "U": return KEY_U;
            case "V": return KEY_V;
            case "W": return KEY_W;
            case "X": return KEY_X;
            case "Y": return KEY_Y;
            case "Z": return KEY_Z;
            case "0": return KEY_0;
            case "1": return KEY_1;
            case "2": return KEY_2;
            case "3": return KEY_3;
            case "4": return KEY_4;
            case "5": return KEY_5;
            case "6": return KEY_6;
            case "7": return KEY_7;
            case "8": return KEY_8;
            case "9": return KEY_9;
            case "ESCAPE": return KEY_ESCAPE;
            case "BACK": return KEY_BACK;
            case "BACKSPACE": return KEY_BACK;
            case "TAB": return KEY_TAB;
            case "RETURN": return KEY_RETURN;
            case "ENTER": return KEY_RETURN;
            case "PAUSE": return KEY_PAUSE;
            case "CAPITAL": return KEY_CAPITAL;
            case "CAPS_LOCK": return KEY_CAPITAL;
            case "SPACE": return KEY_SPACE;
            case "PRIOR": return KEY_PRIOR;
            case "PAGE_UP": return KEY_PRIOR;
            case "NEXT": return KEY_NEXT;
            case "PAGE_DOWN": return KEY_NEXT;
            case "END": return KEY_END;
            case "HOME": return KEY_HOME;
            case "LEFT": return KEY_LEFT;
            case "UP": return KEY_UP;
            case "RIGHT": return KEY_RIGHT;
            case "DOWN": return KEY_DOWN;
            case "INSERT": return KEY_INSERT;
            case "DELETE": return KEY_DELETE;
            case "LWIN": return KEY_LWIN;
            case "RWIN": return KEY_RWIN;
            case "NUMPAD0": return KEY_NUMPAD0;
            case "NUMPAD1": return KEY_NUMPAD1;
            case "NUMPAD2": return KEY_NUMPAD2;
            case "NUMPAD3": return KEY_NUMPAD3;
            case "NUMPAD4": return KEY_NUMPAD4;
            case "NUMPAD5": return KEY_NUMPAD5;
            case "NUMPAD6": return KEY_NUMPAD6;
            case "NUMPAD7": return KEY_NUMPAD7;
            case "NUMPAD8": return KEY_NUMPAD8;
            case "NUMPAD9": return KEY_NUMPAD9;
            case "MULTIPLY": return KEY_MULTIPLY;
            case "ADD": return KEY_ADD;
            case "SEPARATOR": return KEY_SEPARATOR;
            case "SUBTRACT": return KEY_SUBTRACT;
            case "DECIMAL": return KEY_DECIMAL;
            case "DIVIDE": return KEY_DIVIDE;
            case "F1": return KEY_F1;
            case "F2": return KEY_F2;
            case "F3": return KEY_F3;
            case "F4": return KEY_F4;
            case "F5": return KEY_F5;
            case "F6": return KEY_F6;
            case "F7": return KEY_F7;
            case "F8": return KEY_F8;
            case "F9": return KEY_F9;
            case "F10": return KEY_F10;
            case "F11": return KEY_F11;
            case "F12": return KEY_F12;
            case "F13": return KEY_F13;
            case "F14": return KEY_F14;
            case "F15": return KEY_F15;
            case "F16": return KEY_F16;
            case "F17": return KEY_F17;
            case "F18": return KEY_F18;
            case "F19": return KEY_F19;
            case "F20": return KEY_F20;
            case "F21": return KEY_F21;
            case "F22": return KEY_F22;
            case "F23": return KEY_F23;
            case "F24": return KEY_F24;
            case "NUMLOCK": return KEY_NUMLOCK;
            case "SCROLL": return KEY_SCROLL;
            case "SCROLL_LOCK": return KEY_SCROLL;
            case "LSHIFT": return KEY_LSHIFT;
            case "LEFT_SHIFT": return KEY_LSHIFT;
            case "RSHIFT": return KEY_RSHIFT;
            case "RIGHT_SHIFT": return KEY_RSHIFT;
            case "LCONTROL": return KEY_LCONTROL;
            case "LEFT_CONTROL": return KEY_LCONTROL;
            case "RCONTROL": return KEY_RCONTROL;
            case "RIGHT_CONTROL": return KEY_RCONTROL;
            case "LMENU": return KEY_LMENU;
            case "LEFT_ALT": return KEY_LMENU;
            case "RMENU": return KEY_RMENU;
            case "RIGHT_ALT": return KEY_RMENU;
            default: return KEY_NONE;
        }
    }

    /**
     * Check if a key is currently pressed (compatible with Keyboard.isKeyDown()).
     * Uses GLFWWindow to query the current key state.
     */
    public static boolean isKeyDown(int key) {
        return GLFWWindow.isKeyPressed(toGLFW(key));
    }

    /**
     * Get the character for the current key event (compatible with Keyboard.getEventCharacter()).
     */
    public static char getEventCharacter() {
        int key = GLFWWindow.getEventKey();
        if (key >= GLFW_KEY_A && key <= GLFW_KEY_Z) {
            return (char) ('A' + (key - GLFW_KEY_A));
        }
        if (key >= GLFW_KEY_0 && key <= GLFW_KEY_9) {
            return (char) ('0' + (key - GLFW_KEY_0));
        }
        return '\0';
    }

    // Additional key constants needed by the application
    public static final int KEY_NUMPADENTER = 0x9C;

    // Methods from UtilsKeyboard (for compatibility)
    public static String getTooltip(int iFN) {
        return UtilsKeyboard.getTooltip(iFN);
    }

    public static String getFNHumanString(int fn) {
        return UtilsKeyboard.getFNHumanString(fn);
    }

    public static int getKey(int fn, int iIndex) {
        return UtilsKeyboard.getKey(fn, iIndex);
    }

    public static void redefineKey(int iIndex, int iFN, int iKey) {
        UtilsKeyboard.redefineKey(iIndex, iFN, iKey);
    }

    public static boolean isFNKeyDown(int fn) {
        return UtilsKeyboard.isFNKeyDown(fn);
    }

    public static boolean next() {
        return GLFWWindow.keyNext();
    }

    public static int getEventKey() { return GLFWWindow.getEventKey(); }

    public static int getFN(int key) { return UtilsKeyboard.getFN(key); }

    public static void loadShortcuts() { UtilsKeyboard.loadShortcuts(); }

    public static boolean getEventKeyState() {
        return GLFWWindow.getEventKeyState();
    }
}
