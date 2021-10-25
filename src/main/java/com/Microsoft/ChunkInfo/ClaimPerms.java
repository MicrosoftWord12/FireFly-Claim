package com.Microsoft.ChunkInfo;

public enum ClaimPerms {
    CLAIM_ADD("FireFlyClaim.claim"),
    CLAIM_REMOVE("FireFlyClaim.remove");

    private String permission;

    private ClaimPerms(String permission){
        this.permission = permission;
    }
}
