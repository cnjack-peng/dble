package com.actiontech.dble.plan.common.item.function.strfunc;

import com.actiontech.dble.plan.common.item.Item;
import com.actiontech.dble.plan.common.item.function.ItemFunc;
import com.actiontech.dble.plan.common.item.function.primary.ItemIntFunc;

import java.math.BigInteger;
import java.util.List;


public class ItemFuncLength extends ItemIntFunc {

    public ItemFuncLength(List<Item> args) {
        super(args);
    }

    @Override
    public final String funcName() {
        return "length";
    }

    @Override
    public BigInteger valInt() {
        String res = args.get(0).valStr();
        if (res == null) {
            nullValue = true;
            return null; /* purecov: inspected */
        }
        nullValue = false;
        return BigInteger.valueOf(res.length());
    }

    @Override
    public ItemFunc nativeConstruct(List<Item> realArgs) {
        return new ItemFuncLength(realArgs);
    }
}