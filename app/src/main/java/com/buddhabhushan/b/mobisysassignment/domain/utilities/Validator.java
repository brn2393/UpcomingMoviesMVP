package com.buddhabhushan.b.mobisysassignment.domain.utilities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Buddhabhushan on 16-Sep-17.
 */

public final class Validator {
        /**
         * Check to see if Object is empty or null.
         *
         * @param object
         *            The object to check
         * @return boolean {@code true} iff the Object is null or determined to be empty (using methods that it provides --
         *         if it doesn't provide such methods, it's only empty if it's null)
         */
        public static boolean isEmpty(@Nullable final Object object) {
            if (object == null)
                return true;

            try {
                // Try to use the object class's isEmpty method to check if we're empty, now that we know we're
                // not NULL
                final Method method = object.getClass().getMethod("isEmpty");
                final Object result = method.invoke(object);

                if (result instanceof Boolean)
                    return Boolean.class.cast(result).booleanValue();
            } catch (@NonNull final NoSuchMethodException | InvocationTargetException | IllegalArgumentException
                    | IllegalAccessException | SecurityException ignored) {
                // We couldn't invoke... let's go to the next common method
            }

            try {
                // Try to use the object class's length method to check if we're empty, now that we know we're
                // not NULL
                final Method method = object.getClass().getMethod("length");
                final Object result = method.invoke(object);

                if (result instanceof Integer)
                    return Integer.class.cast(result).intValue() <= 0;
                if (result instanceof Long)
                    return Long.class.cast(result).longValue() <= 0L;
            } catch (@NonNull final NoSuchMethodException | InvocationTargetException | IllegalArgumentException
                    | IllegalAccessException | SecurityException ignored) {
                // We couldn't invoke... let's go to the next common method
            }

            try {
                // Try to use the object class's size method to check if we're empty, now that we know we're
                // not NULL
                final Method method = object.getClass().getMethod("size");
                final Object result = method.invoke(object);

                if (result instanceof Integer)
                    return Integer.class.cast(result).intValue() <= 0;
                if (result instanceof Long)
                    return Long.class.cast(result).longValue() <= 0L;
            } catch (@NonNull final NoSuchMethodException | InvocationTargetException | IllegalArgumentException
                    | IllegalAccessException | SecurityException ignored) {
                // We couldn't invoke... but we're not null... treat it like an Object
            }

            // Let's treat it like an Object... we're not null, so we're not empty
            return false;
        }

        /**
         * Check to see if the array of Objects is empty or null.
         *
         * @param obj
         *            Object Array to check
         * @return boolean true if empty
         */
        public static boolean isEmpty(@Nullable final Object... obj) {
            return ((obj == null) || (obj.length == 0));
        }
}
