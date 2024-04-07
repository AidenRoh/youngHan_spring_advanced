package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

	private String id;
	private int level;

	public TraceId() {
		this.id = createId();
		this.level = 0;
	}

	private TraceId(String id, int level) {
		this.id = id;
		this.level = level;
	}

	// ID 생성
	private String createId() {
		//UUID 생성시 ID 전체길이가 너무 길기에 substring으로 앞 8자리만 사용
		return UUID.randomUUID().toString().substring(0, 8);
	}

	// 깊이
	public TraceId createNextId() {
		return new TraceId(id, level + 1);
	}

	public TraceId createPreviousId() {
		return new TraceId(id, level - 1);
	}

	public boolean isFirstLevel() {
		return level == 0;
	}

	//getter
	public String getId() {
		return id;
	}

	public int getLevel() {
		return level;
	}
}
