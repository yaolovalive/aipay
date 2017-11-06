package com.yy.aipay.pojo;

/**
 * 数据库表Auser所对应的实体类
 * 
 * @author
 *
 */
public class Auser {
	private String aid;
	private String qid;
	private String wid;
	private String zid;
	private String afile;
	public Auser()
    {
    }

	/**
	 * 返回aid
	 * 
	 * @return
	 */
	public String getAid() {
		return this.aid;
	}

	/**
	 * 设置aid
	 * 
	 * @param aid
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}

	/**
	 * 返回qid
	 * 
	 * @return
	 */
	public String getQid() {
		return this.qid;
	}

	/**
	 * 设置qid
	 * 
	 * @param qid
	 */
	public void setQid(String qid) {
		this.qid = qid;
	}

	/**
	 * 返回wid
	 * 
	 * @return
	 */
	public String getWid() {
		return this.wid;
	}

	/**
	 * 设置wid
	 * 
	 * @param wid
	 */
	public void setWid(String wid) {
		this.wid = wid;
	}

	/**
	 * 返回zid
	 * 
	 * @return
	 */
	public String getZid() {
		return this.zid;
	}

	/**
	 * 设置zid
	 * 
	 * @param zid
	 */
	public void setZid(String zid) {
		this.zid = zid;
	}

	public String getAfile() {
		return afile;
	}

	public void setAfile(String afile) {
		this.afile = afile;
	}
}
