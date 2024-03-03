import "./header.style.css"

export function Header({title, subtitle}) {
    return (
        <header className="header">
            <h1>{title}</h1>
            <h3>{subtitle}</h3>
        </header>
    )
}