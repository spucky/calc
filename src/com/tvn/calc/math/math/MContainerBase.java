package com.tvn.calc.math.math;

import com.tvn.calc.math.type.Type;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Thilo on 14.10.2015.
 */
public class MContainerBase extends MBase {
    Collection<MBase> container;

    public MContainerBase(Type type) {
        super(type);
    }

    /**
     * Constructor to Change Type of an MContainer
     * @param type type of the new container
     * @param base Container whose type should be changed
     * @param copy determines if the children of base should be copied (by value and deep copy) or if the new container
     *             should use the entire collection from base and make base unusable (by ref)
     */
    public MContainerBase(Type type, MContainerBase base, boolean copy) {
        super(type);
        if (copy) {
            // create new Container and copy all elements from base to this
            container = new ArrayList<>();
            for (MBase mBase : base.container) {
                container.add(mBase);
            }
        } else {
            // use container from base and take away all data from base (to make sure nobody modifies it from outside
            // this)
            container = base.container;
            base.container = null;
        }
    }

    /**
     * Creates a new Container of type with its children taken from collection.
     * @param type type of the new container
     * @param collection collection to take children from
     */
    public MContainerBase(Type type, Collection<MBase> collection, boolean copy) {
        super(type);
        if (copy) {
            // create new container and copy all elements from collection
            container = new ArrayList<>();
            for (MBase mBase : collection) {
                container.add(mBase);
            }
        } else {
            // don't have to copy...
            container = collection;
        }
    }

    /**
     * Creates a new Container of type with children as children
     * @param type type of the new container
     * @param children children of the new container
     */
    public MContainerBase(Type type, MBase... children) {
        super(type);
        // create new container and fill with data from children
        container = new ArrayList<>();
        for (MBase child : children) {
            container.add(child);
        }
    }

    public void append(MBase m) {
        if (m instanceof MContainerBase && type.equals(m.type)) {
            // elements can be added to this collection
            container.addAll(((MContainerBase) m).container);
        } else {
            // otherwise just add complete m to collectoin
            container.add(m);
        }
    }
}
