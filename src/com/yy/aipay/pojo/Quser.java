package com.yy.aipay.pojo;

/**
 * 数据库表Quser所对应的实体类
 * @author 
 *
 */
public class Quser
{
    private String qid;
    private String qname;
    private String qfile;
    public Quser()
    {
    }
    /**
     * 返回qid
     * @return
     */
    public String getQid()
    {
        return this.qid;
    }
    /**
     * 设置qid
     * @param qid
     */
    public void setQid(String qid)
    {
        this.qid = qid;
    }
    /**
     * 返回qname
     * @return
     */
    public String getQname()
    {
        return this.qname;
    }
    /**
     * 设置qname
     * @param qname
     */
    public void setQname(String qname)
    {
        this.qname = qname;
    }
    /**
     * 返回qfile
     * @return
     */
    public String getQfile()
    {
        return this.qfile;
    }
    /**
     * 设置qfile
     * @param qfile
     */
    public void setQfile(String qfile)
    {
        this.qfile = qfile;
    }
}

