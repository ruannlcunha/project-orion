import useGlobalUser from "../context/global-user.context";
import { Navigate } from "react-router-dom";

export function PrivateRouteUsuario({ Screen }) {
  const [user] = useGlobalUser();

  if (user) {
    return <Screen />;
  }
  return <Navigate to={"/"} />;
}
