import React from "react";
import { ButtonStyle } from "./style";

//Propertie size has the values: large, medium, small.
export default function Button(props) {
  let size;

  if (props.size === "large") {
    size = { width: "16em", height: "3em" };
  } else {
    size = { width: "3em", height: "1em" };
  }

  return (
    <ButtonStyle style={size} onClick={props.onClick}>{props.children}</ButtonStyle>
  );
}


