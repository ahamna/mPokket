import { RouterProvider, createBrowserRouter } from "react-router-dom";
import Root from "./pages/Root";
import Error from "./pages/Error";
import AddContact from "./pages/AddContact";
const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    errorElement: <Error />,
    children: [],
  },
  {
    path: "add",
    element: <AddContact />,
  },
]);
function App() {
  return <RouterProvider router={router} />;
}

export default App;
