DROP TABLE t_diagnosis_project;

CREATE TABLE t_diagnosis_project (
    dia_id VARCHAR(50) PRIMARY KEY COMMENT '诊疗项目编码',
    dia_name VARCHAR(100) NOT NULL COMMENT '项目名称',
    dia_exp_type VARCHAR(50) COMMENT '收费类别',
    dia_exp_level VARCHAR(50) COMMENT '收费项目等级',
    dia_max_prize DECIMAL(10,2) COMMENT '最高限价',
    dia_starttime DATE COMMENT '开始日期',
    dia_endtime DATE COMMENT '终止日期',
    dia_valid BOOLEAN COMMENT '有效标志',
    dia_hos_level VARCHAR(50) COMMENT '医院等级',
    dia_approvalmark BOOLEAN COMMENT '是否需要审批标志'
) COMMENT='诊疗项目信息维护表';

