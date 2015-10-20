package com.tvn.calc.math.math;

import com.tvn.calc.math.Base;
import com.tvn.calc.math.set.SBase;
import com.tvn.calc.math.type.Type;

import java.util.List;

/**
 * Created by Thilo on 14.10.2015.
 */
public class MBase extends Base {

    public MBase(Type type) {
        super(type);
    }

    public List<MVar> getVars() {
        return null;
    }

    public boolean containsVar(MVar v) {
        return false;
    }

    public List<MConst> getConstants() {
        return null;
    }

    public boolean containsConst(MConst c){
        return false;
    }

    public SBase getValueRange(MDomain domain) {
        return null;
    }
}
