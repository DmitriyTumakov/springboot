package ru.netology.springboot.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is Dev";
    }
}
