package com.tvn.calc.math.type;

/**
 * Created by Thilo on 14.10.2015.
 */
public class Type {
    private boolean _const;
    private boolean _cont;
    private boolean _asVar;
    private int _arity;
    public final BaseType _baseType;

    public Type(boolean constant, boolean cont, boolean asVar, int arity, BaseType baseType) {
        this._const = constant;
        this._cont = cont;
        this._asVar = asVar;
        this._arity = arity;
        this._baseType = baseType;
    }

    public boolean isConst() {
        return _const;
    }

    public boolean isContainer() {
        return _cont;
    }

    public boolean isBaseType(BaseType t) {
        return t == _baseType;
    }

    public int arity() {
        return _arity;
    }

    public boolean asVar() {
        return _asVar;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Type) {
            // class type is the same, check other attributes
            Type o = ((Type) other);
            return o._const == _const
                    && o._arity == _arity
                    && o._cont == _cont
                    && o._asVar == _asVar
                    && o._baseType == _baseType;
        } else {
            // if class types are not the same, Objects cannot be equal
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[')
                .append(_const ? "const; " : "")
                .append(_cont?"container; ":"")
                .append(_asVar?"as var; ":"")
                .append("arity: ").append(_arity).append("; ")
                .append("BaseType: ").append(_baseType).append("; ")
                .append("]");

        return sb.toString();
    }
}
