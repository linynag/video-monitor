package com.yiwei.common.rabbitmq.config;

public interface RabbitMqConts {
    String MONGO_BACKUP = "mongo_backup.fanout.MongoDataBackup";

    String VALIDATION_TRANSFER = "raw_transfer_yiwei.topic.PlatformValidationToBIT.RAW.";

    String VALIDATION_TRANSFER_REISSUE = ".topic.PlatformValidationToBIT.Reissue.";

    String VALIDATION_TRANSFER_FAILURE = ".topic.PlatformValidationToBIT.Failure.";


    String TRANSFER = "raw_transfer_yiwei.topic.PlatformTransferToBIT.RAW.";

    String TRANSFER_REISSUE = "_transfer.topic.PlatformTransferToBIT.Reissue.";

    String TRANSFER_FAILURE = "_transfer.topic.PlatformTransferToBIT.Failure.";


}
