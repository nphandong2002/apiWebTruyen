package com.example.apiweb.Base;

public class Constants {
    public static class RESPONSE_CODE {
        public static final String SUCCESS = "success";
        public static final String DELETE_SUCCESS = "deleteSuccess";
        public static final String UPDATE_STATUS_SUCCESS = "updateStatusSuccess";
        public static final String UPDATE_SUCCESS = "updateSuccess";
        public static final String ERROR = "error";
        public static final String WARNING = "warning";
        public static final String RECORD_DELETED = "record.deleted";
        public static final String EMAIL_ADDRESS_DELETED = "emailAddress.deleted";
        public static final String RECORD_INUSED = "record.inUsed";
        public static final String RECORD_NOT_EXISTED = "recordNotExits";
        public static final String POSITION_EXISTED = "positionExits";
        public static final String POSITION_WAGE_EXISTED = "positionWageExits";
        public static final String DOCUMENT_TYPE_EXISTED = "documentTypeExits";
        public static final String NOT_ALLOWED_ADD_EMPLOYEE = "employee.notAllowedAddEmployee";
        public static final String NOT_ALLOWED_DELETE_EMPLOYEE = "employee.notAllowedDeleteEmployee";
        public static final String DUPICATE_DATA_REDUCTION = "taxReduction.duplicateData";
        public static final String PARAMETER_USED = "parameterUsed";
        public static final String SYS_CAT_TYPE_USED = "sysCatTypeUsed";
        public static final String ORG_DUPLICATE_CODE = "organization.duplicateCode";
        public static final String ORG_DUPLICATE_NAME = "organization.duplicateName";
        public static final String NATION_CONFIG_TYPE_USED = "nationConfigTypeUsed";
        public static final String EMP_WORK_SCHEDULE_SUCCESS = "empWorkSchedule.success";
        public static final String NOT_ALLOWED_DELETE_DATA_TYPE = "dataType.recordInUsed";
        public static final String NOT_ALLOWED_DELETE_FORMULA = "formula.config.cannotDelete";
        public static final String NOT_ALLOWED_CHANGE_STATUS_FORMULA = "formula.config.cannotChange";
        public static final String NOT_ALLOWED_EVALUATION = "evaluation.cannotEvaluation";
        public static final String NO_RECORDS = "evaluation.noRecords";
        public static final String LOCK_UNIT = "evaluation.orglocked";
        public static final String NO_DATA_EVALUATION = "evaluation.noData";
        public static final String PAYROLL_IS_LOCK = "payroll.isLocked";
        public static final String PAYROLL_IS_PAID = "payroll.isPaid";
        public static final String ROLE_EXIST = "permission.role.exist";
        public static final String MENU_HAVE_CHILD = "permission.menu.haveChild";
        public static final String ERROR_COMPOSITE = "error.composite";
        public static final String SUCCESS_COMPOSITE = "success.composite";
        public static final String ERROR_SEND = "error.send";
        public static final String SUCCESS_SEND = "success.send";
        public static final String SUCCESS_SAVE = "success.save";
        public static final String DELETE_ERROR = "error.delete";
        public static final String SAVE_DUPLICATECODE = "save.duplicateCode";
        public static final String SAVE_DUPLICATE = "save.duplicate";
        public static final String CREDENTIAL = "credential.missing";
        public static final String AUTHENTICATION_FAILED = "authentication.failed";
        public static final String USER_NOT_FOUND = "user.notFound";
        public static final String PW_NOT_VALID = "password.notValid";
        public static final String USER_NOT_VALID = "user.notValid";
        public static final String INTERNAL_SERVER_ERROR = "internal.server.error";
        public static final String PW_NOT_MATCH = "password.not.match";
        public static final String PW_WEAK = "password.weak";
        public static final String EMPLOYEE_BREAK_WORK = "employee.breakWork";
        public static final String DELETE_ERROR_IS_EXIST = "is.exist";
        public static final String DENOUNCE_NOT_RESOLVE = "denounce.not_resolve";
        public static final String DENOUNCE_DUPLICATE_ORG = "denounce.duplicate.org";
        public static final String USER_DUPLICATE_CODE = "save.user.duplicateCode";
        public static final String DOMAIN_DUPLICATECODE = "permission.duplicateDomain";
        public static final String LOCK_ACCOUNT = "account.lock";
        public static final String LOCK_ACCOUNT_15P = "account.lock.15p";
        public static final String PW_MUST_CHANGE = "password.must.change";
        public static final String TOKEN_EXPIRED = "token.expired";
        public static final String CAPTCHA_INVALID = "captcha.invalid";
    }
    public static class RESPONSE_TYPE {
        public static final String SUCCESS = "SUCCESS";
        public static final String ERROR = "ERROR";
        public static final String WARNING = "WARNING";
        public static final String CONFIRM = "CONFIRM";
        public static final String invalidPermission = "invalidPermission";
    }
}
