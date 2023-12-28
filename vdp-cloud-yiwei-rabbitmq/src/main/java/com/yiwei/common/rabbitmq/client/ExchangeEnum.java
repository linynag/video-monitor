package com.yiwei.common.rabbitmq.client;

public enum ExchangeEnum {
    FANOUT ("fanout"), TOPIC ("topic"), DIRECT("direct");

    private String typeName;

    ExchangeEnum(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public static ExchangeEnum getExchangeEnumByName(String typeName){
        ExchangeEnum value = null;
        if(typeName != null && !"".equals(typeName)){
            for(ExchangeEnum temp : ExchangeEnum.values()){
                if(temp.getTypeName().equals(typeName)){
                    value = temp;
                    break;
                }
            }
        }
        return value;
    }
}
