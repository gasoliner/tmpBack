package cn.tmp.po;

import java.util.ArrayList;
import java.util.List;

public class RouteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RouteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRtidIsNull() {
            addCriterion("rtid is null");
            return (Criteria) this;
        }

        public Criteria andRtidIsNotNull() {
            addCriterion("rtid is not null");
            return (Criteria) this;
        }

        public Criteria andRtidEqualTo(Integer value) {
            addCriterion("rtid =", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidNotEqualTo(Integer value) {
            addCriterion("rtid <>", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidGreaterThan(Integer value) {
            addCriterion("rtid >", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rtid >=", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidLessThan(Integer value) {
            addCriterion("rtid <", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidLessThanOrEqualTo(Integer value) {
            addCriterion("rtid <=", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidIn(List<Integer> values) {
            addCriterion("rtid in", values, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidNotIn(List<Integer> values) {
            addCriterion("rtid not in", values, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidBetween(Integer value1, Integer value2) {
            addCriterion("rtid between", value1, value2, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidNotBetween(Integer value1, Integer value2) {
            addCriterion("rtid not between", value1, value2, "rtid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andAidsIsNull() {
            addCriterion("aids is null");
            return (Criteria) this;
        }

        public Criteria andAidsIsNotNull() {
            addCriterion("aids is not null");
            return (Criteria) this;
        }

        public Criteria andAidsEqualTo(String value) {
            addCriterion("aids =", value, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsNotEqualTo(String value) {
            addCriterion("aids <>", value, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsGreaterThan(String value) {
            addCriterion("aids >", value, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsGreaterThanOrEqualTo(String value) {
            addCriterion("aids >=", value, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsLessThan(String value) {
            addCriterion("aids <", value, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsLessThanOrEqualTo(String value) {
            addCriterion("aids <=", value, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsLike(String value) {
            addCriterion("aids like", value, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsNotLike(String value) {
            addCriterion("aids not like", value, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsIn(List<String> values) {
            addCriterion("aids in", values, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsNotIn(List<String> values) {
            addCriterion("aids not in", values, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsBetween(String value1, String value2) {
            addCriterion("aids between", value1, value2, "aids");
            return (Criteria) this;
        }

        public Criteria andAidsNotBetween(String value1, String value2) {
            addCriterion("aids not between", value1, value2, "aids");
            return (Criteria) this;
        }

        public Criteria andVarIsNull() {
            addCriterion("var is null");
            return (Criteria) this;
        }

        public Criteria andVarIsNotNull() {
            addCriterion("var is not null");
            return (Criteria) this;
        }

        public Criteria andVarEqualTo(String value) {
            addCriterion("var =", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotEqualTo(String value) {
            addCriterion("var <>", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarGreaterThan(String value) {
            addCriterion("var >", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarGreaterThanOrEqualTo(String value) {
            addCriterion("var >=", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarLessThan(String value) {
            addCriterion("var <", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarLessThanOrEqualTo(String value) {
            addCriterion("var <=", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarLike(String value) {
            addCriterion("var like", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotLike(String value) {
            addCriterion("var not like", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarIn(List<String> values) {
            addCriterion("var in", values, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotIn(List<String> values) {
            addCriterion("var not in", values, "var");
            return (Criteria) this;
        }

        public Criteria andVarBetween(String value1, String value2) {
            addCriterion("var between", value1, value2, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotBetween(String value1, String value2) {
            addCriterion("var not between", value1, value2, "var");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}