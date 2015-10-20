package com.tvn.calc.math;

import com.tvn.calc.math.type.Type;

/**
 * Created by Thilo on 14.10.2015.
 */
public abstract class Base {
    public final Type type;
    protected boolean _isConst;
    protected boolean _asVar;

    public Base(Type type) {
        this.type = type;
        _isConst = type.isConst();
        _asVar = type.asVar();
    }

    /**
     * Returns the arity of type of the Base. Should be overridden in case of varying arity.
     * @return arity.
     */
    public int arity() {
        return type.arity();
    }

    public boolean isConst() {
        return _isConst;
    }

    public boolean setConst(boolean c) {
        if (type.isConst() && c)
            return false;

        _isConst = c;
        return true;
    }

    public boolean treatAsVar() {
        return _asVar;
    }

    public boolean setTreatAsVar(boolean b) {
        if (type.asVar() && b)
            return false;

        _asVar = b;
        return true;
    }
}
