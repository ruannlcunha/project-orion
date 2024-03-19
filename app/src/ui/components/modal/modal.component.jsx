import "./modal.style.css"

export function Modal({children, isOpen, setIsOpen}) {

    const handleClose = event => {
        event.preventDefault();
    
        if (event.target === event.currentTarget) {
          setIsOpen(false)
        }
    };

    function renderModal() {
        if(isOpen) {
            return (
                <div className="modal" onClick={handleClose}>
                    {children}
                </div>
            )
        }
    }

    return (
        <>
        {renderModal()}
        </>
    )
}