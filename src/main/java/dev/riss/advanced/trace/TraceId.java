package dev.riss.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id;
    private int level;      // 메서드 호출 깊이

    public TraceId() {
        this.id=createId();
        this.level=0;
    }

    private TraceId (String id, int level) {
        this.id=id;
        this.level=level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId () {
        return new TraceId(id, level+1);
    }

    public TraceId createPrevId () {
        return new TraceId(id, level-1);
    }

    public boolean isFirstLevel () {
        return 0==level;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
