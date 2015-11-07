/*
 * Copyright (c) 2015.  Steven van der Baan
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer.
 *
 *     * Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 *     * Neither the name of the OWASP nor the names of its
 *       contributors may be used to endorse or promote products
 *       derived from this software without specific prior written
 *       permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package org.owasp.validator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by steven on 17/09/15.
 */
public class NumberValidator extends Validator<Number> {

    private Number _minValue = null;
    private Number _maxValue = null;
    private boolean _inclusive = false;

    public NumberValidator() {

    }

    public NumberValidator(Number minValue, Number maxValue, boolean inclusive) {
        _minValue = minValue;
        _maxValue = maxValue;
        _inclusive = inclusive;
    }

    @Override
    public void validate(Number number) throws ValidationException {
        if (_minValue == null && _maxValue == null) return;
        if (number instanceof Byte) {
            validate((Byte) number);
        } else if (number instanceof Double) {
            validate((Double) number);
        } else if (number instanceof Float) {
            validate((Float) number);
        } else if (number instanceof Integer) {
            validate((Integer) number);
        } else if (number instanceof Long) {
            validate((Long) number);
        } else if (number instanceof Short) {
            validate((Short) number);
        }
    }

    public void validate(Byte number) throws ValidationException {
        validate(number,
                (_minValue == null) ? Byte.MIN_VALUE : _minValue,
                (_minValue == null) ? Byte.MAX_VALUE : _maxValue
        );
    }

    public void validate(Byte number, Number min, Number max) throws ValidationException {
        System.out.println("validating b " + number.getClass().getCanonicalName());
    }

    public void validate(Double number) throws ValidationException {
        validate(number,
                (_minValue == null) ? Double.MIN_VALUE : _minValue,
                (_minValue == null) ? Double.MAX_VALUE : _maxValue,
                _inclusive
        );
    }

    public void validate(Double number, Number min, Number max, boolean inclusive) throws ValidationException {
        System.out.println("validating d " + number.getClass().getCanonicalName());
        boolean throwException = false;
        if (number.compareTo(min.doubleValue()) == -1) throwException = true;
        if (number.compareTo(max.doubleValue()) == 1) throwException = true;
        if (!inclusive && (number == min.doubleValue() || number == max.doubleValue())) throwException = true;
        if (throwException) throw new ValidationException("");
    }

    public void validate(Float number) throws ValidationException {
        validate(number,
                (_minValue == null) ? Float.MIN_VALUE : _minValue,
                (_minValue == null) ? Float.MAX_VALUE : _maxValue,
                _inclusive
        );
    }

    public void validate(Float number, Number min, Number max, boolean inclusive) throws ValidationException {

    }

    public void validate(Integer number) throws ValidationException {
        validate(number,
                (_minValue == null) ? Integer.MIN_VALUE : _minValue,
                (_minValue == null) ? Integer.MAX_VALUE : _maxValue,
                _inclusive
        );
    }

    public void validate(Integer number, Number min, Number max, boolean inclusive) throws ValidationException {
        System.out.println("validating i " + number.getClass().getCanonicalName());
    }

    public void validate(Long number) throws ValidationException {
        validate(number,
                (_minValue == null) ? Long.MIN_VALUE : _minValue,
                (_minValue == null) ? Long.MAX_VALUE : _maxValue,
                _inclusive
        );
    }

    public void validate(Long number, Number min, Number max, boolean inclusive) throws ValidationException {
        System.out.println("validating l " + number.getClass().getCanonicalName());
    }

    public void validate(Short number) throws ValidationException {
        validate(number,
                (_minValue == null) ? Short.MIN_VALUE : _minValue,
                (_minValue == null) ? Short.MAX_VALUE : _maxValue,
                _inclusive
        );
    }

    public void validate(Short number, Number min, Number max, boolean inclusive) throws ValidationException {
        System.out.println("validating s " + number.getClass().getCanonicalName());
    }

    public void validate(BigDecimal number) throws ValidationException {
//        validate(number,
//                (_minValue == null) ? Byte.MIN_VALUE : _minValue,
//                (_minValue == null) ? Byte.MAX_VALUE : _maxValue
//        );
    }

//    void validate(BigDecimal number, Number min, Number max) throws ValidationException {
//        System.out.println("validating bd " + number.getClass().getCanonicalName());
//    }

    public void validate(BigInteger number) throws ValidationException {
//        validate(number,
//                (_minValue == null) ? Byte.MIN_VALUE : _minValue,
//                (_minValue == null) ? Byte.MAX_VALUE : _maxValue
//        );
    }

//    void validate(BigInteger number, Number min, Number max) throws ValidationException {
//        System.out.println("validating bi " + number.getClass().getCanonicalName());
//    }
}
