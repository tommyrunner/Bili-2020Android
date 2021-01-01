package com.example.tommynews.entity;

import java.io.Serializable;
import java.util.List;

public class AppEntity {

    /**
     * msg : 获取成功
     * code : 200
     * data : {"appName":"Tommy新闻","verstion":"1.0.0","modeList":["推荐","热点","口碑","科技"]}
     */
    private String msg;
    private String code;
    private DataEntity data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public class DataEntity implements Serializable {
        /**
         * appName : Tommy新闻
         * verstion : 1.0.0
         * modeList : ["推荐","热点","口碑","科技"]
         */
        private String appName;
        private String verstion;
        private List<String> modeList;

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public void setVerstion(String verstion) {
            this.verstion = verstion;
        }

        public void setModeList(List<String> modeList) {
            this.modeList = modeList;
        }

        public String getAppName() {
            return appName;
        }

        public String getVerstion() {
            return verstion;
        }

        public List<String> getModeList() {
            return modeList;
        }
    }
}
