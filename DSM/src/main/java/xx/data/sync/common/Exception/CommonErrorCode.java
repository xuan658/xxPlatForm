package xx.data.sync.common.Exception;


/**
 *
 */
public enum CommonErrorCode implements ErrorCode {

    CONFIG_ERROR("Common-00", "您提供的配置文件存在错误信息，请检查您的作业配置 ."),
    WAIT_TIME_EXCEED("Common-01", "等待时间超出范围");

    private final String code;

    private final String describe;

    private CommonErrorCode(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.describe;
    }

    @Override
    public String toString() {
        return String.format("Code:[%s], Describe:[%s]", this.code,
                this.describe);
    }

}
