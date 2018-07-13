package com.amateur.wanbei.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WxUserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库自增长物理主键
     */
    private Integer id;

    /**
     * 此字段允许为空
     * 此字段数据库默认值为: 0
     * 字段描述信息: 是否关注：0-否 1-是
     */
    private Integer subscribe;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 昵称
     * 数据库字段定义长度为: 50
     */
    private String nickname;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 1-男 2-女 0-未知
     * 数据库字段定义长度为: 1
     */
    private String sex;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 国家
     * 数据库字段定义长度为: 50
     */
    private String country;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 省份
     * 数据库字段定义长度为: 50
     */
    private String province;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 城市
     * 数据库字段定义长度为: 50
     */
    private String city;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 语言
     * 数据库字段定义长度为: 50
     */
    private String language;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 头像地址
     * 数据库字段定义长度为: 255
     */
    private String headImgUrl;

    /**
     * 此字段允许为空
     * 此字段数据库没有设置默认值
     * 字段描述信息: 用户分组id
     */
    private Integer groupId;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 公众号运营对粉丝备注
     * 数据库字段定义长度为: 255
     */
    private String remark;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 用户被打上的标签ID列表
     * 数据库字段定义长度为: 255
     */
    private String tagIds;

    /**
     * 此字段允许为空
     * 此字段数据库没有设置默认值
     * 字段描述信息: (取自微信)关注时间
     */
    private Date gmtSubscribe;

    /**
     * 此字段允许为空
     * 此字段数据库没有设置默认值
     * 字段描述信息: 取关时间
     */
    private Date gmtUnsubscribe;

    /**
     * 此字段允许为空
     * 此字段数据库没有设置默认值
     * 字段描述信息: 最近一次获取到的经度
     * 数据库字段保留小数点后 8 位
     */
    private BigDecimal latitude;

    /**
     * 此字段允许为空
     * 此字段数据库没有设置默认值
     * 字段描述信息: 最近一次获取到的经纬度精度
     * 数据库字段保留小数点后 8 位
     */
    private BigDecimal longitude;

    /**
     * 此字段允许为空
     * 此字段数据库没有设置默认值
     * 字段描述信息: 最近一次获取到的经纬度精度
     * 数据库字段保留小数点后 8 位
     */
    private BigDecimal locPrecision;

    /**
     * 此字段允许为空
     * 此字段数据库没有设置默认值
     * 字段描述信息: 最近一次登记经纬度的时间
     */
    private Date gmtLocate;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 备注
     * 数据库字段定义长度为: 255
     */
    private String note;

    /**
     * 此字段允许为空
     * 此字段数据库默认值为: 0
     * 字段描述信息: 逻辑删除标志，是否删除：0-否 1-是
     */
    private Integer deleted;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 创建人
     * 数据库字段定义长度为: 50
     */
    private String creator;

    /**
     * 此字段允许为空
     * 此字段数据库没有设置默认值
     * 字段描述信息: 创建时间
     */
    private Date gmtCreate;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 修改人
     * 数据库字段定义长度为: 50
     */
    private String modifier;

    /**
     * 此字段允许为空
     * 此字段数据库没有设置默认值
     * 字段描述信息: 修改时间
     */
    private Date gmtModify;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 微信open_id
     * 数据库字段定义长度为: 255
     */
    private String openId;

    /**
     * 此字段允许为空
     * 此字段数据库设置默认值为空
     * 字段描述信息: 微信unionId
     * 数据库字段定义长度为: 50
     */
    private String unionId;




    public Integer getId() {
        return id;
    }

    public WxUserProfile withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubscribe() {
        return subscribe;
    }

    public WxUserProfile withSubscribe(Integer subscribe) {
        this.setSubscribe(subscribe);
        return this;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getNickname() {
        return nickname;
    }

    public WxUserProfile withNickname(String nickname) {
        this.setNickname(nickname);
        return this;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSex() {
        return sex;
    }

    public WxUserProfile withSex(String sex) {
        this.setSex(sex);
        return this;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCountry() {
        return country;
    }

    public WxUserProfile withCountry(String country) {
        this.setCountry(country);
        return this;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public WxUserProfile withProvince(String province) {
        this.setProvince(province);
        return this;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public WxUserProfile withCity(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLanguage() {
        return language;
    }

    public WxUserProfile withLanguage(String language) {
        this.setLanguage(language);
        return this;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public WxUserProfile withHeadImgUrl(String headImgUrl) {
        this.setHeadImgUrl(headImgUrl);
        return this;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public WxUserProfile withGroupId(Integer groupId) {
        this.setGroupId(groupId);
        return this;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getRemark() {
        return remark;
    }

    public WxUserProfile withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTagIds() {
        return tagIds;
    }

    public WxUserProfile withTagIds(String tagIds) {
        this.setTagIds(tagIds);
        return this;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds == null ? null : tagIds.trim();
    }

    public Date getGmtSubscribe() {
        return gmtSubscribe;
    }

    public WxUserProfile withGmtSubscribe(Date gmtSubscribe) {
        this.setGmtSubscribe(gmtSubscribe);
        return this;
    }

    public void setGmtSubscribe(Date gmtSubscribe) {
        this.gmtSubscribe = gmtSubscribe;
    }

    public Date getGmtUnsubscribe() {
        return gmtUnsubscribe;
    }

    public WxUserProfile withGmtUnsubscribe(Date gmtUnsubscribe) {
        this.setGmtUnsubscribe(gmtUnsubscribe);
        return this;
    }

    public void setGmtUnsubscribe(Date gmtUnsubscribe) {
        this.gmtUnsubscribe = gmtUnsubscribe;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public WxUserProfile withLatitude(BigDecimal latitude) {
        this.setLatitude(latitude);
        return this;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public WxUserProfile withLongitude(BigDecimal longitude) {
        this.setLongitude(longitude);
        return this;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLocPrecision() {
        return locPrecision;
    }

    public WxUserProfile withLocPrecision(BigDecimal locPrecision) {
        this.setLocPrecision(locPrecision);
        return this;
    }

    public void setLocPrecision(BigDecimal locPrecision) {
        this.locPrecision = locPrecision;
    }

    public Date getGmtLocate() {
        return gmtLocate;
    }

    public WxUserProfile withGmtLocate(Date gmtLocate) {
        this.setGmtLocate(gmtLocate);
        return this;
    }

    public void setGmtLocate(Date gmtLocate) {
        this.gmtLocate = gmtLocate;
    }

    public String getNote() {
        return note;
    }

    public WxUserProfile withNote(String note) {
        this.setNote(note);
        return this;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getDeleted() {
        return deleted;
    }

    public WxUserProfile withDeleted(Integer deleted) {
        this.setDeleted(deleted);
        return this;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getCreator() {
        return creator;
    }

    public WxUserProfile withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public WxUserProfile withGmtCreate(Date gmtCreate) {
        this.setGmtCreate(gmtCreate);
        return this;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getModifier() {
        return modifier;
    }

    public WxUserProfile withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public WxUserProfile withGmtModify(Date gmtModify) {
        this.setGmtModify(gmtModify);
        return this;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getOpenId() {
        return openId;
    }

    public WxUserProfile withOpenId(String openId) {
        this.setOpenId(openId);
        return this;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUnionId() {
        return unionId;
    }

    public WxUserProfile withUnionId(String unionId) {
        this.setUnionId(unionId);
        return this;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

}







