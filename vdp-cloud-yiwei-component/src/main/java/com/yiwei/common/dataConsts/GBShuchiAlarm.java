package com.yiwei.common.dataConsts;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义一个typeMap, 用于存放某个告警项的eventType, 每个eventType标识一个告警的状态
 * @author longxn
 *
 */
public class GBShuchiAlarm {
	public final static int Nomal = 0;
	public final static int Alarm = 1;
	public final static int Alarm_Lever2 = 2;
	public final static int Alarm_Lever3 = 3;
	
	public final static int Error = 254;// 0xFE
	public final static int Invalid = 255;// 0xFF
	public final static int FaultNum = 1;// 故障数,用数字1来做key
	/**  两层map, 结构为{alarmName1:{alarmItem2:alarmItemValue2},alarmName2:{alarmItem2:alarmItemValue2}}  */
	public static final Map<String, Map<Integer,Integer>> typeMap = new HashMap<>();
	private static final Map<Integer, Integer> TemperatureDifferencesAlarm							 = new HashMap<>();
	private static final Map<Integer, Integer> BatteryHighTemperatureAlarm                            = new HashMap<>();
	private static final Map<Integer, Integer> VehicleEnergyStorageDeviceTypeOverpressureAlarm        = new HashMap<>();
	private static final Map<Integer, Integer> VehicleEnergyStorageDeviceTypeUnderpressureAlarm       = new HashMap<>();
	private static final Map<Integer, Integer> SOCLowAlarm                                            = new HashMap<>();
	private static final Map<Integer, Integer> SingleBatteryOverpressureAlarm                         = new HashMap<>();
	private static final Map<Integer, Integer> SingleBatteryUnderpressureAlarm                        = new HashMap<>();
	private static final Map<Integer, Integer> SOCHighAlarm                                           = new HashMap<>();
	private static final Map<Integer, Integer> SOCJumpAlarm                                           = new HashMap<>();
	private static final Map<Integer, Integer> RechargeableEnergyStorageSystemNoMatchAlarm            = new HashMap<>();
	private static final Map<Integer, Integer> BatterySingleConsistencyAlarm                          = new HashMap<>();
	private static final Map<Integer, Integer> BatteriesLowTemperatureAlarm                           = new HashMap<>();
	private static final Map<Integer, Integer> BatteriesOverpressureAlarm                             = new HashMap<>();
	private static final Map<Integer, Integer> BatteriesUnderpressureAlarm                            = new HashMap<>();
	private static final Map<Integer, Integer> BatteriesChargingElectricityAlarm                      = new HashMap<>();
	private static final Map<Integer, Integer> BatteriesDischargeElectricityAlarm                     = new HashMap<>();
	private static final Map<Integer, Integer> VehicleEnergyStorageDeviceTypeOverCharging             = new HashMap<>();
	private static final Map<Integer, Integer> BMSFaultLevel                                          = new HashMap<>();
	private static final Map<Integer, Integer> RechargeableEnergyStorageDeviceFaultCountN1            = new HashMap<>();
	
	private static final Map<Integer, Integer> VehicleControllerStatus                                = new HashMap<>();
	private static final Map<Integer, Integer> HighpressureInterlockingStatusAlarm                    = new HashMap<>();
	private static final Map<Integer, Integer> BrakingSystemAlarm                                     = new HashMap<>();
	private static final Map<Integer, Integer> HighestAlarmLevel                                      = new HashMap<>();
	private static final Map<Integer, Integer> OtherFaultCountN4                                      = new HashMap<>();
	private static final Map<Integer, Integer> DCDCTemperatureAlarm                                   = new HashMap<>();
	private static final Map<Integer, Integer> DCDCStatusAlarm                                        = new HashMap<>();
                                                                                                     
	private static final Map<Integer, Integer> DrivemotorControllerTemperatureAlarm                   = new HashMap<>();
	private static final Map<Integer, Integer> DrivemotorTemperatureAlarm                             = new HashMap<>();
	private static final Map<Integer, Integer> DrivemotorFaultCountN2                                 = new HashMap<>();
                                                                                                     
	private static final Map<Integer, Integer> Shortcircuit_OvercurrentFault                          = new HashMap<>();
	private static final Map<Integer, Integer> MotorTemperatureAlarm                                  = new HashMap<>();
	private static final Map<Integer, Integer> MotorControllerTemperatureAlarm                        = new HashMap<>();
	private static final Map<Integer, Integer> CommunicationFault                                     = new HashMap<>();
	private static final Map<Integer, Integer> RotorSensorFault                                       = new HashMap<>();
                                                                                                    
	private static final Map<Integer, Integer> Shortcircuit_OvercurrentFault2                          = new HashMap<>();
	private static final Map<Integer, Integer> MotorTemperatureAlarm2                                  = new HashMap<>();
	private static final Map<Integer, Integer> MotorControllerTemperatureAlarm2                        = new HashMap<>();
	private static final Map<Integer, Integer> CommunicationFault2                                     = new HashMap<>();
	private static final Map<Integer, Integer> RotorSensorFault2                                       = new HashMap<>();
                                                                                                    
	private static final Map<Integer, Integer> CommunicationFaultAlarm                                = new HashMap<>();
	private static final Map<Integer, Integer> TemperatureFault                                       = new HashMap<>();
	private static final Map<Integer, Integer> OutputOvercurrentFault                                 = new HashMap<>();
	private static final Map<Integer, Integer> OutputOverpressureFault                                = new HashMap<>();
	private static final Map<Integer, Integer> OutputUnderpressureFault                               = new HashMap<>();
	private static final Map<Integer, Integer> InputOverpressureFault                                 = new HashMap<>();
	private static final Map<Integer, Integer> InputUnderpressursFault                                = new HashMap<>();
	private static final Map<Integer, Integer> OutputShortcircuitFault                                = new HashMap<>();
	private static final Map<Integer, Integer> HardwareFault                                          = new HashMap<>();
                                                                                                     
	private static final Map<Integer, Integer> PositivePoleInsulationAlarm                            = new HashMap<>();
	private static final Map<Integer, Integer> CathodeInsulationAlarm                                 = new HashMap<>();
                                                                           
	static {                                                               
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.TemperatureDifferencesAlarm                       ,TemperatureDifferencesAlarm);
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.BatteryHighTemperatureAlarm                        ,BatteryHighTemperatureAlarm                      );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.VehicleEnergyStorageDeviceTypeOverpressureAlarm    ,VehicleEnergyStorageDeviceTypeOverpressureAlarm  );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.VehicleEnergyStorageDeviceTypeUnderpressureAlarm   ,VehicleEnergyStorageDeviceTypeUnderpressureAlarm );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.SOCLowAlarm                                        ,SOCLowAlarm                                      );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.SingleBatteryOverpressureAlarm                     ,SingleBatteryOverpressureAlarm                   );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.SingleBatteryUnderpressureAlarm                    ,SingleBatteryUnderpressureAlarm                  );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.SOCHighAlarm                                       ,SOCHighAlarm                                     );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.SOCJumpAlarm                                       ,SOCJumpAlarm                                     );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.RechargeableEnergyStorageSystemNoMatchAlarm        ,RechargeableEnergyStorageSystemNoMatchAlarm      );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.BatterySingleConsistencyAlarm                      ,BatterySingleConsistencyAlarm                    );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.BatteriesLowTemperatureAlarm                       ,BatteriesLowTemperatureAlarm                     );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.BatteriesOverpressureAlarm                         ,BatteriesOverpressureAlarm                       );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.BatteriesUnderpressureAlarm                        ,BatteriesUnderpressureAlarm                      );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.BatteriesChargingElectricityAlarm                  ,BatteriesChargingElectricityAlarm                );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.BatteriesDischargeElectricityAlarm                 ,BatteriesDischargeElectricityAlarm               );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.VehicleEnergyStorageDeviceTypeOverCharging         ,VehicleEnergyStorageDeviceTypeOverCharging       );
		typeMap.put(GBShuChiDataKeyConst.BatteriesAllDataMessage2.key + "_" + GBShuChiDataKeyConst.BatteriesAllDataMessage2.BMSFaultLevel                                      ,BMSFaultLevel                                    );
		typeMap.put(GBShuChiDataKeyConst.ChargingControlInformation.key + "_" + GBShuChiDataKeyConst.ChargingControlInformation.RechargeableEnergyStorageDeviceFaultCountN1      ,RechargeableEnergyStorageDeviceFaultCountN1      );
                                                                           
		typeMap.put(GBShuChiDataKeyConst.VehicleControllerInformation1.key + "_" + GBShuChiDataKeyConst.VehicleControllerInformation1.VehicleControllerStatus                       ,VehicleControllerStatus                          );      
		typeMap.put(GBShuChiDataKeyConst.VehicleControllerInformation1.key + "_" + GBShuChiDataKeyConst.VehicleControllerInformation1.HighpressureInterlockingStatusAlarm           ,HighpressureInterlockingStatusAlarm              );                  
		typeMap.put(GBShuChiDataKeyConst.VehicleControllerInformation1.key + "_" + GBShuChiDataKeyConst.VehicleControllerInformation1.BrakingSystemAlarm                            ,BrakingSystemAlarm                               ); 
		typeMap.put(GBShuChiDataKeyConst.VehicleControllerInformation1.key + "_" + GBShuChiDataKeyConst.VehicleControllerInformation1.HighestAlarmLevel                             ,HighestAlarmLevel                                );
		typeMap.put(GBShuChiDataKeyConst.VehicleControllerInformation2.key + "_" + GBShuChiDataKeyConst.VehicleControllerInformation2.OtherFaultCountN4                             ,OtherFaultCountN4                                );
		typeMap.put(GBShuChiDataKeyConst.AccessoryControlInformation.key + "_" + GBShuChiDataKeyConst.AccessoryControlInformation.DCDCTemperatureAlarm                            ,DCDCTemperatureAlarm                             );   
		typeMap.put(GBShuChiDataKeyConst.AccessoryControlInformation.key + "_" + GBShuChiDataKeyConst.AccessoryControlInformation.DCDCStatusAlarm                                 ,DCDCStatusAlarm                                  );
                                                                                                                                                                    
		typeMap.put(GBShuChiDataKeyConst.MasterdriveStatus3.key + "_" + GBShuChiDataKeyConst.MasterdriveStatus3.DrivemotorControllerTemperatureAlarm                     ,DrivemotorControllerTemperatureAlarm             );                    
		typeMap.put(GBShuChiDataKeyConst.MasterdriveStatus3.key + "_" + GBShuChiDataKeyConst.MasterdriveStatus3.DrivemotorTemperatureAlarm                               ,DrivemotorTemperatureAlarm                       );                    
		typeMap.put(GBShuChiDataKeyConst.MasterdriveStatus3.key + "_" + GBShuChiDataKeyConst.MasterdriveStatus3.DrivemotorFaultCountN2                                   ,DrivemotorFaultCountN2                           );             
                                                                                                                                                                
		typeMap.put(GBShuChiDataKeyConst.AirPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.AirPumpControllerInformation.Shortcircuit_OvercurrentFault                  ,Shortcircuit_OvercurrentFault                    );                          
		typeMap.put(GBShuChiDataKeyConst.AirPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.AirPumpControllerInformation.MotorTemperatureAlarm                          ,MotorTemperatureAlarm                            );                  
		typeMap.put(GBShuChiDataKeyConst.AirPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.AirPumpControllerInformation.MotorControllerTemperatureAlarm                ,MotorControllerTemperatureAlarm                  );                            
		typeMap.put(GBShuChiDataKeyConst.AirPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.AirPumpControllerInformation.CommunicationFault                             ,CommunicationFault                               );               
		typeMap.put(GBShuChiDataKeyConst.AirPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.AirPumpControllerInformation.RotorSensorFault                               ,RotorSensorFault                                 );             
		                                                                                                                                                          
		typeMap.put(GBShuChiDataKeyConst.OilPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.OilPumpControllerInformation.Shortcircuit_OvercurrentFault                  ,Shortcircuit_OvercurrentFault2                    );                           
		typeMap.put(GBShuChiDataKeyConst.OilPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.OilPumpControllerInformation.MotorTemperatureAlarm                          ,MotorTemperatureAlarm2                            );                   
		typeMap.put(GBShuChiDataKeyConst.OilPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.OilPumpControllerInformation.MotorControllerTemperatureAlarm                ,MotorControllerTemperatureAlarm2                  );                             
		typeMap.put(GBShuChiDataKeyConst.OilPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.OilPumpControllerInformation.CommunicationFault                             ,CommunicationFault2                               );                
		typeMap.put(GBShuChiDataKeyConst.OilPumpControllerInformation.key + "_" + GBShuChiDataKeyConst.OilPumpControllerInformation.RotorSensorFault                               ,RotorSensorFault2                                );              
                                                                                                                                                                   
		typeMap.put(GBShuChiDataKeyConst.DCDCControllerInformation.key + "_" + GBShuChiDataKeyConst.DCDCControllerInformation.CommunicationFaultAlarm                           ,CommunicationFaultAlarm                          );                  
		typeMap.put(GBShuChiDataKeyConst.DCDCControllerInformation.key + "_" + GBShuChiDataKeyConst.DCDCControllerInformation.TemperatureFault                                  ,TemperatureFault                                 );   
		typeMap.put(GBShuChiDataKeyConst.DCDCControllerInformation.key + "_" + GBShuChiDataKeyConst.DCDCControllerInformation.OutputOvercurrentFault                            ,OutputOvercurrentFault                           );                   
		typeMap.put(GBShuChiDataKeyConst.DCDCControllerInformation.key + "_" + GBShuChiDataKeyConst.DCDCControllerInformation.OutputOverpressureFault                           ,OutputOverpressureFault                          );       
		typeMap.put(GBShuChiDataKeyConst.DCDCControllerInformation.key + "_" + GBShuChiDataKeyConst.DCDCControllerInformation.OutputUnderpressureFault                          ,OutputUnderpressureFault                         );      
		typeMap.put(GBShuChiDataKeyConst.DCDCControllerInformation.key + "_" + GBShuChiDataKeyConst.DCDCControllerInformation.InputOverpressureFault                            ,InputOverpressureFault                           );
		typeMap.put(GBShuChiDataKeyConst.DCDCControllerInformation.key + "_" + GBShuChiDataKeyConst.DCDCControllerInformation.InputUnderpressursFault                           ,InputUnderpressursFault                          );
		typeMap.put(GBShuChiDataKeyConst.DCDCControllerInformation.key + "_" + GBShuChiDataKeyConst.DCDCControllerInformation.OutputShortcircuitFault                           ,OutputShortcircuitFault                          );
		typeMap.put(GBShuChiDataKeyConst.DCDCControllerInformation.key + "_" + GBShuChiDataKeyConst.DCDCControllerInformation.HardwareFault                                     ,HardwareFault                                    );
                                                                                                                                                                  
		typeMap.put(GBShuChiDataKeyConst.InsulationDetectorInformation.key + "_" + GBShuChiDataKeyConst.InsulationDetectorInformation.PositivePoleInsulationAlarm                   ,PositivePoleInsulationAlarm                      );                        
		typeMap.put(GBShuChiDataKeyConst.InsulationDetectorInformation.key + "_" + GBShuChiDataKeyConst.InsulationDetectorInformation.CathodeInsulationAlarm                        ,CathodeInsulationAlarm                           );                   

		/**
		 * @Fields ALARM_MASK_TEMP_DIFF : 1温度差异报警 0正常
		 */
		TemperatureDifferencesAlarm.put(Nomal, 600100);
		TemperatureDifferencesAlarm.put(Alarm, 600101);
		TemperatureDifferencesAlarm.put(Alarm_Lever2, 600102);
		TemperatureDifferencesAlarm.put(Alarm_Lever3, 600103);
		
		BatteryHighTemperatureAlarm.put(Nomal, 600200);
		BatteryHighTemperatureAlarm.put(Alarm, 600201);
		BatteryHighTemperatureAlarm.put(Alarm_Lever2, 600202);
		BatteryHighTemperatureAlarm.put(Alarm_Lever3, 600203);
		
		VehicleEnergyStorageDeviceTypeOverpressureAlarm.put(Nomal, 600300);
		VehicleEnergyStorageDeviceTypeOverpressureAlarm.put(Alarm, 600301);
		
		VehicleEnergyStorageDeviceTypeUnderpressureAlarm.put(Nomal, 600400);
		VehicleEnergyStorageDeviceTypeUnderpressureAlarm.put(Alarm, 600401);
		
		SOCLowAlarm.put(Nomal, 600500);
		SOCLowAlarm.put(Alarm, 600501);
		SOCLowAlarm.put(Alarm_Lever2, 600502);
		SOCLowAlarm.put(Alarm_Lever3, 600503);
		
		SingleBatteryOverpressureAlarm.put(Nomal, 600600);
		SingleBatteryOverpressureAlarm.put(Alarm, 600601);
		SingleBatteryOverpressureAlarm.put(Alarm_Lever2, 600602);
		SingleBatteryOverpressureAlarm.put(Alarm_Lever3, 600603);
		
		SingleBatteryUnderpressureAlarm.put(Nomal, 600700);
		SingleBatteryUnderpressureAlarm.put(Alarm, 600701);
		SingleBatteryUnderpressureAlarm.put(Alarm_Lever2, 600702);
		SingleBatteryUnderpressureAlarm.put(Alarm_Lever3, 600703);
		
		SOCHighAlarm.put(Nomal, 600800);
		SOCHighAlarm.put(Alarm, 600801);
		
		SOCJumpAlarm.put(Nomal, 600900);
		SOCJumpAlarm.put(Alarm, 600901);
		
		RechargeableEnergyStorageSystemNoMatchAlarm.put(Nomal, 601000);
		RechargeableEnergyStorageSystemNoMatchAlarm.put(Alarm, 601001);
		
		BatterySingleConsistencyAlarm.put(Nomal, 601100);
		BatterySingleConsistencyAlarm.put(Alarm, 601101);
		
		BatteriesLowTemperatureAlarm.put(Nomal, 601200);
		BatteriesLowTemperatureAlarm.put(Alarm, 601201);
		BatteriesLowTemperatureAlarm.put(Alarm_Lever2, 601202);
		BatteriesLowTemperatureAlarm.put(Alarm_Lever3, 601203);
		
		BatteriesOverpressureAlarm.put(Nomal, 601300);
		BatteriesOverpressureAlarm.put(Alarm, 601301);
		BatteriesOverpressureAlarm.put(Alarm_Lever2, 601302);
		BatteriesOverpressureAlarm.put(Alarm_Lever3, 601303);
		
		BatteriesUnderpressureAlarm.put(Nomal, 601400);
		BatteriesUnderpressureAlarm.put(Alarm, 601401);
		BatteriesUnderpressureAlarm.put(Alarm_Lever2, 601402);
		BatteriesUnderpressureAlarm.put(Alarm_Lever3, 601403);
		
		BatteriesChargingElectricityAlarm.put(Nomal, 601500);
		BatteriesChargingElectricityAlarm.put(Alarm, 601501);
		BatteriesChargingElectricityAlarm.put(Alarm_Lever2, 601502);
		BatteriesChargingElectricityAlarm.put(Alarm_Lever3, 601503);
		
		BatteriesDischargeElectricityAlarm.put(Nomal, 601600);
		BatteriesDischargeElectricityAlarm.put(Alarm, 601601);
		BatteriesDischargeElectricityAlarm.put(Alarm_Lever2, 601602);
		BatteriesDischargeElectricityAlarm.put(Alarm_Lever3, 601603);
		
		VehicleEnergyStorageDeviceTypeOverCharging.put(Nomal, 601700);
		VehicleEnergyStorageDeviceTypeOverCharging.put(Alarm, 601701);
		
		BMSFaultLevel.put(Nomal, 601800);
		BMSFaultLevel.put(Alarm, 601801);
		BMSFaultLevel.put(Alarm_Lever2, 601802);
		BMSFaultLevel.put(Alarm_Lever3, 601803);
		
		RechargeableEnergyStorageDeviceFaultCountN1.put(Nomal, 601900);
		RechargeableEnergyStorageDeviceFaultCountN1.put(Error, 6019254);
		RechargeableEnergyStorageDeviceFaultCountN1.put(Invalid, 6019255);
		RechargeableEnergyStorageDeviceFaultCountN1.put(FaultNum, 6019000);
		
		/**
		 * 整车控制器告警
		 */
		VehicleControllerStatus.put(Nomal, 610100);
		VehicleControllerStatus.put(Alarm, 610101);
		
		HighpressureInterlockingStatusAlarm.put(Nomal, 610200);
		HighpressureInterlockingStatusAlarm.put(Alarm, 610201);
		
		BrakingSystemAlarm.put(Nomal, 610300);
		BrakingSystemAlarm.put(Alarm, 610301);
		
		HighestAlarmLevel.put(Nomal, 610400);
		HighestAlarmLevel.put(Alarm, 610401);
		HighestAlarmLevel.put(Alarm_Lever2, 610402);
		HighestAlarmLevel.put(Alarm_Lever3, 610403);
		
		OtherFaultCountN4.put(Nomal, 610500);
		OtherFaultCountN4.put(Error, 6105254);
		OtherFaultCountN4.put(Invalid, 6105255);
		OtherFaultCountN4.put(FaultNum, 6105000);
		
		DCDCTemperatureAlarm.put(Nomal, 610700);
		DCDCTemperatureAlarm.put(Alarm, 610701);
		
		DCDCStatusAlarm.put(Nomal, 610800);
		DCDCStatusAlarm.put(Alarm, 610801);
		
		/**
		 * 电机控制器告警
		 */
		DrivemotorControllerTemperatureAlarm.put(Nomal, 620100);
		DrivemotorControllerTemperatureAlarm.put(Alarm, 620101);
		
		DrivemotorTemperatureAlarm.put(Nomal, 620200);
		DrivemotorTemperatureAlarm.put(Alarm, 620201);
		
		DrivemotorFaultCountN2.put(Nomal, 620300);
		DrivemotorFaultCountN2.put(Error, 6203254);
		DrivemotorFaultCountN2.put(Invalid, 6203255);
		DrivemotorFaultCountN2.put(FaultNum, 6203000);
		
		/**
		 * 气泵告警
		 */
		Shortcircuit_OvercurrentFault.put(Nomal, 630100);
		Shortcircuit_OvercurrentFault.put(Alarm, 630101);
		MotorTemperatureAlarm.put(Nomal, 630200);
		MotorTemperatureAlarm.put(Alarm, 630201);
		MotorControllerTemperatureAlarm.put(Nomal, 630300);
		MotorControllerTemperatureAlarm.put(Alarm, 630301);
		CommunicationFault.put(Nomal, 630400);
		CommunicationFault.put(Alarm, 630401);
		RotorSensorFault.put(Nomal, 630500);
		RotorSensorFault.put(Alarm, 630501);
		
		/**
		 * 油泵告警
		 */
		Shortcircuit_OvercurrentFault2.put(Nomal, 640100);
		Shortcircuit_OvercurrentFault2.put(Alarm, 640101);
		MotorTemperatureAlarm2.put(Nomal, 640200);
		MotorTemperatureAlarm2.put(Alarm, 640201);
		MotorControllerTemperatureAlarm2.put(Nomal, 640300);
		MotorControllerTemperatureAlarm2.put(Alarm, 640301);
		CommunicationFault2.put(Nomal, 640400);
		CommunicationFault2.put(Alarm, 640401);
		RotorSensorFault2.put(Nomal, 640500);
		RotorSensorFault2.put(Alarm, 640501);
		
		/**
		 * DCDC 控制器告警
		 */
		CommunicationFaultAlarm.put(Nomal, 650100);
		CommunicationFaultAlarm.put(Alarm, 650101);
		TemperatureFault.put(Nomal, 650200);
		TemperatureFault.put(Alarm, 650201);
		OutputOvercurrentFault.put(Nomal, 650300);
		OutputOvercurrentFault.put(Alarm, 650301);
		OutputOverpressureFault.put(Nomal, 650400);
		OutputOverpressureFault.put(Alarm, 650401);
		OutputUnderpressureFault.put(Nomal, 650500);
		OutputUnderpressureFault.put(Alarm, 650501);
		InputOverpressureFault.put(Nomal, 650600);
		InputOverpressureFault.put(Alarm, 650601);
		InputUnderpressursFault.put(Nomal, 650700);
		InputUnderpressursFault.put(Alarm, 650701);
		OutputShortcircuitFault.put(Nomal, 650800);
		OutputShortcircuitFault.put(Alarm, 650801);
		HardwareFault.put(Nomal, 650900);
		HardwareFault.put(Alarm, 650901);
		
		/**
		 * 绝缘检测仪告警
		 */
		PositivePoleInsulationAlarm.put(Nomal, 660100);
		PositivePoleInsulationAlarm.put(Alarm_Lever3, 660101);
		PositivePoleInsulationAlarm.put(Alarm_Lever2, 660102);
		PositivePoleInsulationAlarm.put(Alarm, 660103);
		
		
		CathodeInsulationAlarm.put(Nomal, 660200);
		CathodeInsulationAlarm.put(Alarm_Lever3, 660201);
		CathodeInsulationAlarm.put(Alarm_Lever2, 660202);
		CathodeInsulationAlarm.put(Alarm, 660203);
	}

}
