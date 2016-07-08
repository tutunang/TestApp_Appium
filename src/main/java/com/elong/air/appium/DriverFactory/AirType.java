package com.elong.air.appium.DriverFactory;

public enum AirType {
	 /**
	  * 7.1折经济舱
	  * 全价经济舱
	  * 商务舱
	  * 头等舱
	  */
	 None(0),
	 /**
	  * 商务优选
	  */
	 BusinessOptimization(1),
//	 /**
//	  * 旅行套餐
//	  */
//	 TravelPackages(2),
	 /**
	  * 优选套餐30选1
	  */
	 PreferredPackages(3),
	 /**
	  * 航司直连
	  */
	 Direct(4),
//	 /**
//	  * 普通政策
//	  */
//	 GeneralPolicy(5),
//	 /**
//	  * 商务产品
//	  */
//	 BusinessProduct(6),
//	 /**
//	  * 旅行套餐and租车优惠券
//	  */
//	 TravelPackagesAndCoupons(7),
	 /**
	  * 艺龙旅行套餐(ps==2，与携程旅行套餐无关)
	  */
	 ElongTravelPackages(8);


     // 定义私有变量

     private   int   nCode ;



     // 构造函数，枚举类型只能为私有

     private AirType( int _nCode) {

         this . nCode = _nCode;

    }
     @Override

     public String toString() {

         return String.valueOf ( this . nCode );

    }
     public static void main(String[] args) {
    
	}

}
