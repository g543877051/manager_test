package com.gz.manager.domain;

public class Baike {
	 private final String name;
	 private int age;
	 private String locate;
	 private String job;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getLocate() {
		return locate;
	}

	public String getJob() {
		return job;
	}

	Baike(BaikeBuilder baikeBuilder){
		this.name = baikeBuilder.name;
		this.age = baikeBuilder.age;
		this.locate = baikeBuilder.locate;
		this.job = baikeBuilder.job;
	}

	public static class BaikeBuilder{
		final String name;
		int age;
		String locate;
		String job;

		public BaikeBuilder(String name) {
			this.name = name;
		}

		public BaikeBuilder age(int age){
			this.age =age;
			return this;
		}

		public BaikeBuilder locate(String locate){
			this.locate = locate;
			return this;
		}

		public BaikeBuilder job(String job){
			this.job = job;
			return this;
		}

		public Baike builder(){
			return new Baike(this);
		}
	}
}
