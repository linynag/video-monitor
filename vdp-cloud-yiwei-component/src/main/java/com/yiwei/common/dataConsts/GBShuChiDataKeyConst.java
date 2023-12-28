package com.yiwei.common.dataConsts;
/**
 * 对GBShuChiCanDataParserConfig1.ini中key进行常量化,用于从解析后的json中获取数据
 * key的具体含义请参考shuchi协议和GBShuChiCanDataParserConfig2.ini
 * @author longxn
 */
public interface GBShuChiDataKeyConst {
	
	/**
	 * 终端心跳数据中的GPS模块状态数据字段key 常量定义
	 */
	interface GpsState {
		String key = "GpsState";
		String KeySwitcherACC="KeySwitcherACC";
		String GpsLocate="GpsLocate";
		String ReceivedSatellitesCount="ReceivedSatellitesCount";
		String GpsModuleState="GpsModuleState";
		String PowerSupplyState="PowerSupplyState";
	}
	
	/**
	 * 电池组总体数据信息1
	 * @author longxn
	 */
	interface BatteriesAllDataMessage1 {
		String key = "BatteriesAllDataMessage1";
		String BMSSystemWorkStatus="BMSSystemWorkStatus";
		String InsideOverallStatus="InsideOverallStatus";
		String ChargingStatusFeedback="ChargingStatusFeedback";
		String HeatingStatus="HeatingStatus";
		String SumVoltage="SumVoltage";
		String SumElectricity="SumElectricity";
		String SOC="SOC";
		String BatteriesMaxChargingVoltage="BatteriesMaxChargingVoltage";
	}
	/**
	 * 电池组总体数据信息2
	 * @author longxn
	 */
	interface BatteriesAllDataMessage2 {
		String key = "BatteriesAllDataMessage2";
		String TemperatureDifferencesAlarm="TemperatureDifferencesAlarm";
		String BatteryHighTemperatureAlarm="BatteryHighTemperatureAlarm";
		String VehicleEnergyStorageDeviceTypeOverpressureAlarm="VehicleEnergyStorageDeviceTypeOverpressureAlarm";
		String VehicleEnergyStorageDeviceTypeUnderpressureAlarm="VehicleEnergyStorageDeviceTypeUnderpressureAlarm";
		String SOCLowAlarm="SOCLowAlarm";
		String SingleBatteryOverpressureAlarm="SingleBatteryOverpressureAlarm";
		String SingleBatteryUnderpressureAlarm="SingleBatteryUnderpressureAlarm";
		String SOCHighAlarm="SOCHighAlarm";
		String SOCJumpAlarm="SOCJumpAlarm";
		String RechargeableEnergyStorageSystemNoMatchAlarm="RechargeableEnergyStorageSystemNoMatchAlarm";
		String BatterySingleConsistencyAlarm="BatterySingleConsistencyAlarm";
		String BatteriesLowTemperatureAlarm="BatteriesLowTemperatureAlarm";
		String BatteriesOverpressureAlarm="BatteriesOverpressureAlarm";
		String BatteriesUnderpressureAlarm="BatteriesUnderpressureAlarm";
		String BatteriesChargingElectricityAlarm="BatteriesChargingElectricityAlarm";
		String BatteriesDischargeElectricityAlarm="BatteriesDischargeElectricityAlarm";
		String VehicleEnergyStorageDeviceTypeOverCharging="VehicleEnergyStorageDeviceTypeOverCharging";
		String VehicleEnergyStorageDeviceType="VehicleEnergyStorageDeviceType";
		String HighestVoltageBatterySubsystemNumber="HighestVoltageBatterySubsystemNumber";
		String LowestVoltageBatterySubsystemNumber="LowestVoltageBatterySubsystemNumber";
		String BMSFaultLevel="BMSFaultLevel";
	}
	/**
	 * 电池组电压1
	 */
	interface BatteriesVoltage1{
		String key = "BatteriesVoltage1";
		String BatterySingleVoltageHighest="BatterySingleVoltageHighest";
		String BatterySingleVoltageLowest="BatterySingleVoltageLowest";
		String SingleAverageVoltage="SingleAverageVoltage";
		String HighestVoltageBatterySingleMark="HighestVoltageBatterySingleMark";
		String LowestVoltageBatterySingleMark="LowestVoltageBatterySingleMark";
	}
	/**
	 * 电池组温度1
	 * @author longxn
	 */
	interface BatteriesTemperature1{
		String key = "BatteriesTemperature1";
		String HighestTemperature="HighestTemperature";
		String LowestTemperature="LowestTemperature";
		String SubsystemAverageTemperature="SubsystemAverageTemperature";
		String HighestTemperatureSubsystemNumber="HighestTemperatureSubsystemNumber";
		String LowestTemperatureSubsystemNumber="LowestTemperatureSubsystemNumber";
		String HighestTemperatureNeedleSerialNumber="HighestTemperatureNeedleSerialNumber";
		String LowestTemperatureNeedleSerialNumber="LowestTemperatureNeedleSerialNumber";
	}
	/**
	 * 充电控制信息
	 * @author longxn
	 */
	interface ChargingControlInformation{
		String key = "ChargingControlInformation";
		String ElectricityHeatContactorControl="ElectricityHeatContactorControl";
		String ChargingContactorControl="ChargingContactorControl";
		String RechargeableEnergyStorageDeviceFaultCountN1="RechargeableEnergyStorageDeviceFaultCountN1";
		String RechargeAbleEnergyStorageDeviceFaultCodeList="RechargeAbleEnergyStorageDeviceFaultCodeList";
	}
	/**
	 * 充电参数广播帧
	 */
	interface ChargingParameterBroadcast{
		String key = "ChargingParameterBroadcast";
		String HighestChargingVoltage="HighestChargingVoltage";
		String RealityRequireChargingElectricity="RealityRequireChargingElectricity";
		String Control="Control";
		String SingleNumber="SingleNumber";
	}
	/**
	 * BMS系统参数1
	 * @author longxn
	 */
	interface SystemParamter1{
		String key = "SystemParamter1";
		String SingleVoltageAlarmUpperlimit="SingleVoltageAlarmUpperlimit";
		String SingleVoltageCutoffUpperlimit="SingleVoltageCutoffUpperlimit";
		String SingleVoltageAlarmLowerlimit="SingleVoltageAlarmLowerlimit";
		String SingleVoltageCutoffLowerlimit="SingleVoltageCutoffLowerlimit";
	}
	/**
	 * BMS系统参数2
	 * @author longxn
	 */
	interface SystemParamter2{
		String key = "SystemParamter2";
		String SingleVoltageDeviationAlarm="SingleVoltageDeviationAlarm";
		String RatedBiggestChargingElectricity="RatedBiggestChargingElectricity";
		String RatedBiggestDischargeELectricity="RatedBiggestDischargeELectricity";
		String RatedCapacity="RatedCapacity";
	}
	/**
	 * 可充电储能子系统数据信息1
	 * @author longxn
	 */
	interface RechargeableEnergyStorageSubsystemDataInformation1{
		String key = "RechargeableEnergyStorageSubsystemDataInformation1";
		String RechargeableEnergyStorageSubsystemCount="RechargeableEnergyStorageSubsystemCount";
		String SingleBatteryCount="SingleBatteryCount";
		String RechargeableEnergyStorageTemperatureNeedleCount="RechargeableEnergyStorageTemperatureNeedleCount";
	}
	/**
	 * 可充电储能子系统数据信息2
	 * @author longxn
	 */
	interface RechargeableEnergyStorageSubsystemDataInformation2{
		String key = "RechargeableEnergyStorageSubsystemDataInformation2";
		String RechargeableEnergyStorageSubsystemNumber="RechargeableEnergyStorageSubsystemNumber";
		String DataPackageNumber="DataPackageNumber";
		String VoltageNumber="VoltageNumber";
	}
	/**
	 * 可充电储能子系统数据信息3
	 * @author longxn
	 */
	interface RechargeableEnergyStorageSubsystemDataInformation3{
		String key = "RechargeableEnergyStorageSubsystemDataInformation3";
		String RechargeableEnergyStorageSubsystemNumber="RechargeableEnergyStorageSubsystemNumber";
		String DataPackageNumber="DataPackageNumber";
		String SingleTemperatureNumber="SingleTemperatureNumber";
	}
	/**
	 * 整车控制器信息1
	 * @author longxn
	 */
	interface VehicleControllerInformation1{
		String key = "VehicleControllerInformation1";
		String VehicleControllerStatus="VehicleControllerStatus";
		String ChangegearPanelStatus="ChangegearPanelStatus";
		String HighpressureInterlockingStatusAlarm="HighpressureInterlockingStatusAlarm";
		String BrakingSystemAlarm="BrakingSystemAlarm";
		String VehicleStatus="VehicleStatus";
		String OperationModel="OperationModel";
		String Speed="Speed";
		String Gear="Gear";
		String BrakingforceStatus="BrakingforceStatus";
		String DrivingforceStatus="DrivingforceStatus";
		String ChargingStatus="ChargingStatus";
		String HighestAlarmLevel="HighestAlarmLevel";
	}
	/**
	 * 整车控制器信息2
	 * @author longxn
	 */
	interface VehicleControllerInformation2{
		String key = "VehicleControllerInformation2";
		String ExpeditePedalJourneyValue="ExpeditePedalJourneyValue";
		String BrakingPedalStatus="BrakingPedalStatus";
		String OtherFaultCountN4="OtherFaultCountN4";
		String OtherFaultCodeList="OtherFaultCodeList";
		String DrivemotorNumber="DrivemotorNumber";
	}
	/**
	 * 附件控制信息
	 * @author longxn
	 */
	interface AccessoryControlInformation{
		String key = "AccessoryControlInformation";
		String OilPumpControllerControllOrder="OilPumpControllerControllOrder";
		String AirPumpControllerControllOrder="AirPumpControllerControllOrder";
		String AirConditionerTransducerControlOrder="AirConditionerTransducerControlOrder";
		String DC_DCControlOrder="DC/DCControlOrder";
		String DC_DCStatus="DC/DCStatus";
		String DCDCTemperatureAlarm="DCDCTemperatureAlarm";
		String DCDCStatusAlarm="DCDCStatusAlarm";
	}
	/**
	 * 主驱状态1
	 * @author longxn
	 */
	interface MasterdriveStatus1{
		String key = "MasterdriveStatus1";
		String DrivemotorSerialNumber="DrivemotorSerialNumber";
		String DrivemotorStatus="DrivemotorStatus";
		String DrivemotorTemperature="DrivemotorTemperature";
		String DrivemotorControllerTemperature="DrivemotorControllerTemperature";
		String ElectromotorControllerInputVoltage="ElectromotorControllerInputVoltage";
		String ElectromotorControllerCocurrentElectricity="ElectromotorControllerCocurrentElectricity";
	}
	/**
	 * 主驱状态2
	 * @author longxn
	 */
	interface MasterdriveStatus2{
		String key = "MasterdriveStatus2";
		String DrivemotorNumber="DrivemotorNumber";
		String DrivemotorRotatespeed="DrivemotorRotatespeed";
		String DrivemotorTorque="DrivemotorTorque";
	}
	/**
	 * 主驱状态3
	 * @author longxn
	 */
	interface MasterdriveStatus3{
		String key = "MasterdriveStatus3";
		String DrivemotorNumber="DrivemotorNumber";
		String DrivemotorControllerTemperatureAlarm="DrivemotorControllerTemperatureAlarm";
		String DrivemotorTemperatureAlarm="DrivemotorTemperatureAlarm";
		String DrivemotorFaultCountN2="DrivemotorFaultCountN2";
		String DrivemotorFaultCodeList="DrivemotorFaultCodeList";
	}
	/**
	 * 气泵控制器信息
	 * @author longxn
	 */
	interface AirPumpControllerInformation{
		String key = "AirPumpControllerInformation";
		String Shortcircuit_OvercurrentFault="Shortcircuit/OvercurrentFault";
		String MotorTemperatureAlarm="MotorTemperatureAlarm";
		String MotorControllerTemperatureAlarm="MotorControllerTemperatureAlarm";
		String CommunicationFault="CommunicationFault";
		String RotorSensorFault="RotorSensorFault";
		String MotorWorkingStatus="MotorWorkingStatus";
		String MotorRate="MotorRate";
		String MotorTemperature="MotorTemperature";
		String MotorControllerTemperature="MotorControllerTemperature";
		String GeneratrixVoltage="GeneratrixVoltage";
		String Rotatespeed="Rotatespeed";
	}
	/**
	 * 油泵控制器信息
	 * @author longxn
	 */
	interface OilPumpControllerInformation{
		String key = "OilPumpControllerInformation";
		String Shortcircuit_OvercurrentFault="Shortcircuit/OvercurrentFault";
		String MotorTemperatureAlarm="MotorTemperatureAlarm";
		String MotorControllerTemperatureAlarm="MotorControllerTemperatureAlarm";
		String CommunicationFault="CommunicationFault";
		String RotorSensorFault="RotorSensorFault";
		String MotorWorkingStatus="MotorWorkingStatus";
		String MotorRate="MotorRate";
		String MotorTemperature="MotorTemperature";
		String MotorControllerTemperature="MotorControllerTemperature";
		String GeneratrixVoltage="GeneratrixVoltage";
		String Rotatespeed="Rotatespeed";
	}
	/**
	 * DCDC控制器信息
	 * @author longxn
	 */
	interface DCDCControllerInformation{
		String key = "DCDCControllerInformation";
		String WorkStatus="WorkStatus";
		String CommunicationFaultAlarm="CommunicationFaultAlarm";
		String TemperatureFault="TemperatureFault";
		String OutputOvercurrentFault="OutputOvercurrentFault";
		String OutputOverpressureFault="OutputOverpressureFault";
		String OutputUnderpressureFault="OutputUnderpressureFault";
		String InputOverpressureFault="InputOverpressureFault";
		String InputUnderpressursFault="InputUnderpressursFault";
		String OutputShortcircuitFault="OutputShortcircuitFault";
		String HardwareFault="HardwareFault";
		String WorkTemperature="WorkTemperature";
		String OutputElectricity="OutputElectricity";
		String OutputVoltage="OutputVoltage";
		String GeneratrixVoltage="GeneratrixVoltage";
	}
	/**
	 * 绝缘检测仪信息
	 * @author longxn
	 */
	interface InsulationDetectorInformation{
		String key = "InsulationDetectorInformation";
		String InsulationResistance="InsulationResistance";
		String PositivePoleInsulationAlarm="PositivePoleInsulationAlarm";
		String CathodeInsulationAlarm="CathodeInsulationAlarm";
		String PositivePoleInsulationValue="PositivePoleInsulationValue";
		String CathodeInsulationValue="CathodeInsulationValue";
		String UnitWorkingStatus="UnitWorkingStatus";
	}
	/**
	 * 仪表信息1
	 * @author longxn
	 */
	interface InstrumentInformation1{
		String key = "InstrumentInformation1";
		String Speed="Speed";
		String Rotatespeed="Rotatespeed";
		String WaterTemperature="WaterTemperature";
		String MachineoilPressure="MachineoilPressure";
		String PreviousAirpressure="PreviousAirpressure";
		String BehindAirpressure="BehindAirpressure";
		String OilMass="OilMass";
		String VehicleVoltage="VehicleVoltage";
	}
	/**
	 * 仪表信息2
	 * @author longxn
	 */
	interface InstrumentInformation2{
		String key = "InstrumentInformation2";
		String DippedHeadlight="DippedHeadlight";
		String HighBeam="HighBeam";
		String FrontFogLamp="FrontFogLamp";
		String RearFogLamp="RearFogLamp";
		String BackupLight="BackupLight";
		String Stoplight="Stoplight";
		String TurnLeft="TurnLeft";
		String TurnRight="TurnRight";
		String LightInCar1Switch="LightInCar1Switch";
		String LightInCar2Switch="LightInCar2Switch";
		String HandBrakeSignal="HandBrakeSignal";
		String Standby1="Standby1";
		String NeutralPosition="NeutralPosition";
		String Standby2="Standby2";
		String FrontGateOpenSignal="FrontGateOpenSignal";
		String BehindGateOpenSignal="BehindGateOpenSignal";
		String FrontEscapeDoorSwitch="FrontEscapeDoorSwitch";
		String BehindEscapeDoorSwitch="BehindEscapeDoorSwitch";
		String BehindCabinDoorSwitch="BehindCabinDoorSwitch";
		String AirFilterBlockingAlarm="AirFilterBlockingAlarm";
		String WaterLevelTooLowSignal="WaterLevelTooLowSignal";
		String LampletSwitch="LampletSwitch";
		String TrumpetSwitch="TrumpetSwitch";
		String GuideboardLightSwitch="GuideboardLightSwitch";
		String DriverFanSwitch="DriverFanSwitch";
		String WindscreenWiperSwitch="WindscreenWiperSwitch";
		String SyringeSwitch="SyringeSwitch";
		String ABSWork="ABSWork";
		String RetarderWork="RetarderWork";
		String LeftShoeAbrasionAlarm="LeftShoeAbrasionAlarm";
		String RightShoeAbrasionAlarm="RightShoeAbrasionAlarm";
		String EngineCabinTemperatureAlarm="EngineCabinTemperatureAlarm";
		String MileageCount="MileageCount";
	}
	
}
