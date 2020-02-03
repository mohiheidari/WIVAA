package com.vulnerable.wivaa;

public class VulJni {
    static
    {
        System.loadLibrary("VulJni");
    }

    public native int access(String key);
    public native int initiateLaunchSequence(String code);
}
