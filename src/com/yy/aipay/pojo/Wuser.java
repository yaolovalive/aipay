package com.yy.aipay.pojo;

/**
 * 数据库表Wuser所对应的实体类
 * @author 
 *
 */
public class Wuser
{
    private String wid;
    private String wname;
    private String wfile;
    public Wuser()
    {
    }
    /**
     * 返回wid
     * @return
     */
    public String getWid()
    {
        return this.wid;
    }
    /**
     * 设置wid
     * @param wid
     */
    public void setWid(String wid)
    {
        this.wid = wid;
    }
    /**
     * 返回wname
     * @return
     */
    public String getWname()
    {
        return this.wname;
    }
    /**
     * 设置wname
     * @param wname
     */
    public void setWname(String wname)
    {
        this.wname = wname;
    }
    /**
     * 返回wfile
     * @return
     */
    public String getWfile()
    {
        return this.wfile;
    }
    /**
     * 设置wfile
     * @param wfile
     */
    public void setWfile(String wfile)
    {
        this.wfile = wfile;
    }
}

