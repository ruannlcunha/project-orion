import { useState } from "react";

const errorMessage = "Campo obrigatório";
export function useForm(initialFormData) {
  const [formData, setFormData] = useState(initialFormData);

  function handleChange({ target }) {
    const fieldValue = target.value;
    const fieldName = target.name;
    setFormData((pastInfo) => ({
      ...pastInfo,
      [fieldName]: {
        value: fieldValue,
        error: fieldValue ? "" : errorMessage,
      },
    }));
  }

  return { formData, handleChange, setFormData };
}
