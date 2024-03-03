import "./content-section.style.css"

export function ContentSection({title, text}) {

    return (
        <div className="content-section">
            <h1>{title}</h1>
            <p>{text}</p>
        </div>
    )

}