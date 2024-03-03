import { RouterProvider } from "react-router-dom";
import { GlobalUserProvider } from "./context/global-user.context";
import { router } from "./router";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <GlobalUserProvider>
        <ToastContainer />
        <RouterProvider router={router}/>
    </GlobalUserProvider>
  )
  
}

export default App
