package com.yy.aipay.pojo;

/**
 * 数据库表Zuser所对应的实体类
 * @author 
 *
 */
public class Zuser
{
    private String zid;
    private String zfile;
    public Zuser()
    {
    }
    /**
     * 返回zid
     * @return
     */
    public String getZid()
    {
        return this.zid;
    }
    /**
     * 设置zid
     * @param zid
     */
    public void setZid(String zid)
    {
        this.zid = zid;
    }
    /**
     * 返回zfile
     * @return
     */
    public String getZfile()
    {
        return this.zfile;
    }
    /**
     * 设置zfile
     * @param zfile
     */
    public void setZfile(String zfile)
    {
        this.zfile = zfile;
    }
}
