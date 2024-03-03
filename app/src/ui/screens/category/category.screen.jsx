import { useParams } from "react-router-dom"
import { ContainerScreen, Header, CategoryItem, BackButton} from "../../components"
import "./category.style.css"

export function CategoryScreen() {
    const { campaignId } = useParams()

    return (
        <ContainerScreen>
            <div className="category-screen">
                <Header title={"Categorias"} subtitle={"Escolha qual categoria deseja ver"}/>
                <BackButton/>
                <section>
                    <CategoryItem campaignId={campaignId} categoryId={1} name={"Personagens"}/>
                    <CategoryItem campaignId={campaignId} categoryId={2} name={"Criaturas"}/>
                    <CategoryItem campaignId={campaignId} categoryId={3} name={"Itens"}/>
                    <CategoryItem campaignId={campaignId} categoryId={4} name={"Histórias"}/>
                    <CategoryItem campaignId={campaignId} categoryId={5} name={"Locais"}/>
                    <CategoryItem campaignId={campaignId} categoryId={6} name={"Outros"}/>
                </section>
            </div>
        </ContainerScreen>
    )

}