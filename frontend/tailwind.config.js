/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}", "./node_modules/flowbite/**/*.js"],
  theme: {
    extend: {
      colors: {
        nav: "#242441",
        tab: "#F38020B2",
      },
      height: {
        tab: "480px",
      },
    },
  },
  plugins: [require("flowbite/plugin")],
};
