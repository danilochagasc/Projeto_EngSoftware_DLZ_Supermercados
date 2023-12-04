import { useContext } from "react";
import { SideBarContext } from "../contexts/sideBarContext";

export default function useSide() {
  const context = useContext(SideBarContext);

  return context;
}