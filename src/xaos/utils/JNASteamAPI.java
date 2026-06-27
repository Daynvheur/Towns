package xaos.utils;

// JNA not available - Steam API stub
/*
import com.sun.jna.Library;

public interface JNASteamAPI extends Library {

    boolean SteamAPI_Init();
}
*/
// Stub interface without JNA
public interface JNASteamAPI {

    default boolean SteamAPI_Init() {
        return false;
    }
}
