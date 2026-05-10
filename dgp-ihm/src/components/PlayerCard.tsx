import type { Player } from "../types/player";
import "./PlayerCard.css";

interface Props {
  player: Player;
}

export function PlayerCard({ player }: Props) {
  const SCALE = 2;
  const FRAME_SIZE = 64;
  const FRAME_X = 0;
  const FRAME_Y = 200;
  const SHEET_SIZE = 512;

  return (
    <div
      className="border-2 border-isaac-border bg-isaac-panel p-3
    hover:border-isaac-blood transition-colors flex flex-col items-center"
    >
      <div
        style={{
          width: FRAME_SIZE * SCALE,
          height: FRAME_SIZE * SCALE,
          backgroundImage: `url(${player.skin})`,
          backgroundPosition: `-${FRAME_X * SCALE}px -${FRAME_Y * SCALE}px`,
          backgroundSize: `${SHEET_SIZE * SCALE}px ${SHEET_SIZE * SCALE}px`,
          imageRendering: "pixelated",
        }}
      />
      <h3 className="mt-2 text-center text-isaac-text font-pixel text-xs">
        {player.name}
      </h3>
    </div>
  );
}
