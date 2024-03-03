import "./menu.style.css"
import { ButtonPrimary, ContainerScreen } from "../../components"
import { useSound } from "../../../hook"
import { useNavigate } from "react-router-dom";

export function MenuScreen() {
    const { playClick } = useSound();
    const navigate = useNavigate();

    function handleLibrary() {
        playClick()
        navigate("/library/campaign")
    }

    function handleExit() {
        playClick()
        navigate("/")
    }

    return (
        <ContainerScreen>
            <div className="menu-screen">
                <header>
                    <h1>MENU</h1>
                </header>
                <section>
                    <section className="menu-left">
                        <ButtonPrimary onClick={playClick}>Jogar</ButtonPrimary>
                        <ButtonPrimary onClick={handleLibrary}>Biblioteca</ButtonPrimary>
                        <ButtonPrimary onClick={playClick}>Configurações</ButtonPrimary>
                        <ButtonPrimary onClick={handleExit}>Sair</ButtonPrimary>
                    </section>
                </section>
            </div>
        </ContainerScreen>
    )

}