package cn.chinaunicom.posstandardpos.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author zhangchi
 * @since 2018-11-09
 */
@TableName("ehrcuc_pos_tree_v")
@ApiModel("VIEW")
public class PosTreeV extends Model<PosTreeV> {

    private static final long serialVersionUID = 1L;
    private Long posId;//基准岗位ID
    @TableField("SKID")
    private BigDecimal skid;
    @TableField("SKNAME")
    private String skname;
    @TableField("KID")
    private Long kid;
    @TableField("KNAME")
    private String kname;
    @TableField("KCODE")
    private String kcode;
    @TableField("ATTRIBUTE1")
    private String attribute1;
    @TableField("ATTRIBUTE2")
    private String attribute2;
    @TableField("ATTRIBUTE3")
    private String attribute3;
    @TableField("ATTRIBUTE4")
    private String attribute4;
    @TableField("ATTRIBUTE5")
    private String attribute5;
    @TableField("ATTRIBUTE6")
    private String attribute6;
    @TableField("ATTRIBUTE7")
    private String attribute7;
    @TableField("ATTRIBUTE8")
    private String attribute8;
    @TableField("ATTRIBUTE9")
    private String attribute9;
    @TableField("ATTRIBUTE10")
    private String attribute10;
    @TableField("MID")
    private Long mid;
    @TableField("MNAME")
    private String mname;
    @TableField("SID")
    private BigDecimal sid;
    @TableField("SNAME")
    private String sname;
    @TableField("CID")
    private BigDecimal cid;
    @TableField("CNAME")
    private String cname;
    @TableField("ULEVEL")
    private String ulevel;
    @TableField("SKSTR")
    private Integer skstr;


    @TableField(exist = false)
    private String elementName;
    @TableField(exist = false)
    private String elementId;
    private List<PosTreeV> kList;
    private List<PosTreeV> skList;




    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<PosTreeV> getkList() {
        return kList;
    }

    public void setkList(List<PosTreeV> kList) {
        this.kList = kList;
    }

    public List<PosTreeV> getSkList() {
        return skList;
    }

    public void setSkList(List<PosTreeV> skList) {
        this.skList = skList;
    }

    public BigDecimal getSkid() {
        return skid;
    }

    public void setSkid(BigDecimal skid) {
        this.skid = skid;
    }

    public String getSkname() {
        return skname;
    }

    public void setSkname(String skname) {
        this.skname = skname;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public String getKcode() {
        return kcode;
    }

    public void setKcode(String kcode) {
        this.kcode = kcode;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public Long getKid() {
        return kid;
    }

    public void setKid(Long kid) {
        this.kid = kid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public BigDecimal getSid() {
        return sid;
    }

    public void setSid(BigDecimal sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public BigDecimal getCid() {
        return cid;
    }

    public void setCid(BigDecimal cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUlevel() {
        return ulevel;
    }

    public void setUlevel(String ulevel) {
        this.ulevel = ulevel;
    }

    public Integer getSkstr() {
        return skstr;
    }

    public void setSkstr(Integer skstr) {
        this.skstr = skstr;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }
    private String isExistAss;//某专业是否已经被分配
    private String isExistSk;//某关键职责是否已经被分配

    public String getIsExistAss() {
        return isExistAss;
    }

    public void setIsExistAss(String isExistAss) {
        this.isExistAss = isExistAss;
    }

    public String getIsExistSk() {
        return isExistSk;
    }

    public void setIsExistSk(String isExistSk) {
        this.isExistSk = isExistSk;
    }

    //    private Long mid;//专业ID
//    private Long kid;//职责ID
//    private String mname;//专业名称
//    private String kname;//职责名称
//    private String skname;//子职责名称
    private String inFlag;
    private String kstr;//职责列表
    private String subRespStr;//关键职责对应子职责字符串
    public String getSubRespStr() {
        return subRespStr;
    }
    public void setSubRespStr(String subRespStr) {
        this.subRespStr = subRespStr;
    }
    public String getInFlag() {
        return inFlag;
    }
    public void setInFlag(String inFlag) {
        this.inFlag = inFlag;
    }
    public String getKstr() {
        return kstr;
    }
    public void setKstr(String kstr) {
        this.kstr = kstr;
    }
    @Override
    public String toString() {
        return "PosTreeV{" +
        ", skid=" + skid +
        ", skname=" + skname +
        ", kid=" + kid +
        ", kname=" + kname +
        ", kcode=" + kcode +
        ", attribute1=" + attribute1 +
        ", attribute2=" + attribute2 +
        ", attribute3=" + attribute3 +
        ", attribute4=" + attribute4 +
        ", attribute5=" + attribute5 +
        ", attribute6=" + attribute6 +
        ", attribute7=" + attribute7 +
        ", attribute8=" + attribute8 +
        ", attribute9=" + attribute9 +
        ", attribute10=" + attribute10 +
        ", mid=" + mid +
        ", mname=" + mname +
        ", sid=" + sid +
        ", sname=" + sname +
        ", cid=" + cid +
        ", cname=" + cname +
        ", ulevel=" + ulevel +
        ", skstr=" + skstr +
        "}";
    }
}
