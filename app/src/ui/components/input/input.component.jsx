import "./input.style.css"

export function Input({label, name, value, type, onChange, placeholder}) {
    return (
        <div className="input-container">
            <label>{label}</label>
            <input
            name={name}
            value={value}
            type={type}
            onChange={onChange}
            placeholder={placeholder}
            />
        </div>
    )
}