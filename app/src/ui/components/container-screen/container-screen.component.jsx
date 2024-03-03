import "./container-screen.style.css"

export function ContainerScreen({children}) {
    return (
        <div className="container-screen">
            {children}
        </div>
    )
}