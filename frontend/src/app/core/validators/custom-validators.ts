import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function digitLengthValidator(requiredLength: number): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const value = control.value?.toString() || '';
    if (!value) {
      return null;
    }
    return value.length === requiredLength
      ? null
      : { digitLength: { requiredLength, actualLength: value.length } };
  };
}

export function exactDigitLengthValidator(length: number): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const value = control.value?.toString() || '';
    if (!value) {
      return null;
    }
    return value.length === length
      ? null
      : {
          exactDigitLength: {
            requiredLength: length,
            actualLength: value.length,
          },
        };
  };
}

export function nameValidator(
  minLength: number,
  maxLength: number
): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const value = control.value?.toString() || '';
    const isValidLength =
      value.length >= minLength && value.length <= maxLength;
    const isAlpha = /^[a-zA-Z\s]+$/.test(value);

    if (!value) return null; // Boş değer için hata yok

    return isValidLength && isAlpha
      ? null
      : {
          nameError: {
            requiredLength: `${minLength}-${maxLength}`,
            actualLength: value.length,
          },
        };
  };
}

export function gsmNumberValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const value = control.value?.toString() || '';
    if (!value) {
      return null;
    }
    const isValid = /^\d{10}$/.test(value);
    return isValid
      ? null
      : {
          gsmNumberError: {
            requiredLength: 10,
            actualLength: value.length,
          },
        };
  };
}

export function maxDigitLengthValidator(maxLength: number): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const value = control.value?.toString() || '';
    // Eğer değer tam olarak `maxLength` uzunluğundaysa hata döndür
    return value.length === maxLength
      ? { maxDigitLength: { requiredLength: maxLength } }
      : null;
  };
}
