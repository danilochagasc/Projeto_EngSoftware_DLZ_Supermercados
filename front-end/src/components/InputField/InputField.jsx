import React from "react";
import { Input } from "./style";

export default function InputField(props) {

  return (
    <Input placeholder={props.placeholder} type={props.type} onChange={props.onChange} required />
  );
}