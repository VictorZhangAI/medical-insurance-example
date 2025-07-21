DROP TABLE t_service_facilities;

CREATE TABLE t_service_facilities (
    ser_id VARCHAR(50) PRIMARY KEY COMMENT '医疗服务设施编码',
    ser_name VARCHAR(100) NOT NULL COMMENT '服务设施名称',
    ser_exp_type VARCHAR(50) COMMENT '收费类别',
    ser_starttime DATE COMMENT '开始日期',
    ser_endtime DATE COMMENT '终止日期',
    ser_valid BOOLEAN COMMENT '有效标志'
) COMMENT='服务设施项目维护表';

