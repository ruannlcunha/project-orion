import { ContainerScreen, ButtonPrimary } from "../../components"
import logo1 from "../../../assets/image/title_1.png"
import logo2 from "../../../assets/image/title_2.png"
import whiteScreen from "../../../assets/image/white_screen.png"
import "./start.style.css"
import { useNavigate } from "react-router-dom";
import { useState } from "react"
import { useSound } from "../../../hook"

export function StartScreen() {
    const [started, setStarted] = useState(false);
    const navigate = useNavigate()
    const { playHover, playStart } = useSound();

    function handleLogin() {
        playStart()
        setStarted(true)
        setTimeout(()=>{navigate("/login")}, 4000 )
    }

    function handleRegister() {
        playStart()
        setStarted(true)
        setTimeout(()=>{navigate("/register")}, 4000 )
    }


    return (
        <ContainerScreen>
            <div className={"start-screen"}>
                {started? <img src={whiteScreen} alt="Tela Branca" className="white-screen" /> : null}
                <div className={"title-orion"}>
                    <img src={logo2} alt="Logo de Orion" className={started?"shine-animation-started":"shine-animation"} />
                    <img src={logo1} alt="Logo de Orion" className={started?"fadeout-animation":null}/>
                </div>
                <button 
                onClick={handleLogin}
                onMouseEnter={playHover}
                className={started?"fadeout-animation":null}
                >Entrar
                </button>
                <button 
                onClick={handleRegister}
                onMouseEnter={playHover}
                className={started?"fadeout-animation":null}
                >Cadastrar
                </button>
            </div>
        </ContainerScreen>
    )
}