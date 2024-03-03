import "./menu.style.css"
import { ButtonPrimary, ContainerScreen } from "../../components"
import { useSound } from "../../../hook"
import { useNavigate } from "react-router-dom";
import { useLogout } from "../../../hook/api/auth/use-logout.hook";

export function MenuScreen() {
    const { logout } = useLogout();
    const { playClick } = useSound();
    const navigate = useNavigate();

    function handleLibrary() {
        playClick()
        navigate("/library/campaign")
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
                        <ButtonPrimary onClick={logout}>Sair</ButtonPrimary>
                    </section>
                </section>
            </div>
        </ContainerScreen>
    )

}